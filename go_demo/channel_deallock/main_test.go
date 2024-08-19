package channel_deallock

import (
	"fmt"
	"testing"
)

// TestDeadLock1 main routine blocked!
func TestDeadLock1(t *testing.T) {
	chanWithTwoCache := make(chan int, 2)
	chanWithTwoCache <- 1
	fmt.Println("输入信号 1")
	chanWithTwoCache <- 2
	fmt.Println("输入信号 2")
	chanWithTwoCache <- 3
	fmt.Println("输入信号 3")
	close(chanWithTwoCache)
	// OUTPUT:
	// 输入信号 1
	// 输入信号 2
	// fatal error: all goroutines are asleep - deadlock!
}
