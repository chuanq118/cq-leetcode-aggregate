package panic_recover

import (
	"fmt"
	"testing"
	"time"
)

// TestMultiDeferOrder 多个 defer 按栈模式执行
func TestMultiDeferOrder(t *testing.T) {
	ch := make(chan struct{})
	go func() {
		defer func() {
			fmt.Println("first defined defer exec.")
			ch <- struct{}{}
		}()
		defer func() {
			fmt.Println("second defined defer exec.")
			ch <- struct{}{}
		}()
		panic(fmt.Errorf("%s\n", "panic err."))
	}()
	<-ch
	<-ch
	fmt.Println("main exit")
	// === RUN   TestMultiDeferOrder
	// second defined defer exec.
	// first defined defer exec.
	// main exit
	// --- PASS: TestMultiDeferOrder (0.00s)
	// panic: panic err.
}

func TestPanicRecover(t *testing.T) {
	go func() {
		defer func() {
			fmt.Println("first defined defer exec.")
			if r := recover(); r != nil {
				fmt.Printf("first recover err -> [%v]\n", r)
			}
			panic("first defer panic err.")
		}()
		defer func() {
			fmt.Println("second defined defer exec.")
			if r := recover(); r != nil {
				fmt.Printf("second recover err -> [%v]\n", r)
			}
			panic("second defer panic err.")
		}()
		panic(fmt.Errorf("%s", "go func panic err."))
	}()

	time.Sleep(3 * time.Second)
	fmt.Println("main exit")

	// === RUN   TestPanicRecover
	// second defined defer exec.
	// second recover err -> [go func panic err.]
	// first defined defer exec.
	// first recover err -> [second defer panic err.]
	// panic: go func panic err. [recovered]
	//	panic: second defer panic err. [recovered]
	//	panic: first defer panic err.
}
