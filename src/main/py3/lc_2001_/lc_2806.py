class Solution:
    def accountBalanceAfterPurchase(self, purchaseAmount: int) -> int:
        idx = 0
        while idx * 10 < purchaseAmount:
            idx += 1
        if idx == 0:
            return 100
        diff1 = abs(purchaseAmount - (idx - 1) * 10)
        diff2 = abs(purchaseAmount - idx * 10)
        payment = idx * 10 if diff1 >= diff2 else (idx - 1) * 10
        return 100 - payment
