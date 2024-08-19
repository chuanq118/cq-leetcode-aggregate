package channel_deallock

import (
	"fmt"
	"testing"
	"time"
)

// TestDeadLock1 main routine blocked!
// 类似的, 在 main routine 中从空信道中取值也会造成死锁
func TestDeadLock1(t *testing.T) {
	chanWithTwoCache := make(chan int, 2)
	fmt.Println("无输入信号 : len =", len(chanWithTwoCache))
	chanWithTwoCache <- 1
	fmt.Println("输入信号 1 : len =", len(chanWithTwoCache))
	chanWithTwoCache <- 2
	fmt.Println("输入信号 2 : len =", len(chanWithTwoCache))
	chanWithTwoCache <- 3
	fmt.Println("输入信号 3 : len =", len(chanWithTwoCache))
	close(chanWithTwoCache)
	// OUTPUT:
	// 输入信号 1
	// 输入信号 2
	// fatal error: all goroutines are asleep - deadlock!
}

// TestDeadLock2 这种场景不会出现死锁,阻塞的是非 main routine
func TestDeadLock2(t *testing.T) {
	chanWithOneCache := make(chan int, 1)
	go func() {
		<-chanWithOneCache
	}()
	time.Sleep(2 * time.Second)
	fmt.Println("ok end.")
}

// TestDeadLock3 这种情况不会死锁,如果 取输入或者输出 任一对 ch1/ch2 的顺序改变,同样会出现死锁
func TestDeadLock3(t *testing.T) {
	ch1 := make(chan string)
	ch2 := make(chan string)
	go func() {
		fmt.Println("enter go func.")
		ch1 <- "ch2 value"
		fmt.Println("ch2 inp end.")
		ch2 <- "ch1 value"
		fmt.Println("ch1 inp end.")
	}()

	fmt.Println("before out.")
	<-ch1
	fmt.Println("ch2 out end.")
	<-ch2
	fmt.Println("ch1 out end.")
}

// TestDeadLock4 子协程死锁但不影响 main routine 照样不会死锁退出
func TestDeadLock4(t *testing.T) {
	ch1 := make(chan string)
	ch2 := make(chan string)
	go func() {
		ch1 <- "111"
		fmt.Println("ch1 inp ok.")
		ch2 <- "222"
	}()
	go func() {
		<-ch2
		fmt.Println("ch2 out ok.")
		<-ch1
	}()
	time.Sleep(2 * time.Second)
	fmt.Println("main end.")
	// === RUN   TestDeadLock4
	// main end.
	// --- PASS: TestDeadLock4 (2.00s)
	// PASS
}
