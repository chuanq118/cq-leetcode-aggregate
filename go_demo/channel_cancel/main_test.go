package channel_cancel

import (
	"context"
	"fmt"
	"testing"
	"time"
)

func TestCancelChannel(t *testing.T) {
	// type backgroundCtx struct{ emptyCtx }
	// type todoCtx struct{ emptyCtx }
	ctx, cancelCmd := context.WithCancel(context.TODO())
	blockedMain := make(chan int)

	go func(ctx context.Context) {
		for {
			select {
			case <-ctx.Done():
				fmt.Println("cancel...")
				blockedMain <- 0
				return
			default:
				fmt.Println("running...")
				time.Sleep(1 * time.Second)
			}
		}
	}(ctx)

	time.Sleep(3 * time.Second)
	cancelCmd()
	<-blockedMain
	fmt.Println("done.")
}

func TestSelect(t *testing.T) {
	ch1 := make(chan int, 1)
	ch1 <- 0
	select {
	case <-ch1:
		fmt.Println("select...")
		return
	default:
		fmt.Println("not select")
	}
	fmt.Println("end.")
}
