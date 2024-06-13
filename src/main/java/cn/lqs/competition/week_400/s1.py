class Solution:
    def minimumChairs(self, s: str) -> int:
        currentChairs = 0
        maxChairs = 0

        for char in s:
            if char == 'E':
                currentChairs += 1
            elif char == 'L':
                currentChairs -= 1
            maxChairs = max(maxChairs, currentChairs)

        return maxChairs