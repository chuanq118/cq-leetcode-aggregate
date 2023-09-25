package cn.lqs.leetcode_1993;

class LockingTree {

    private final LockStatus[] locks;

    public LockingTree(int[] parent) {
      locks = new LockStatus[parent.length];
    }
    
    public boolean lock(int num, int user) {
      if(locks[num].locked){
        return locks[num].userId == user;
      }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        return false;
    }

    static class LockStatus{
      int userId;
      boolean locked;
      public LockStatus(){
        this.locked = false;
        this.userId = 0;
      }
    }

    public static void main(String[] args) {
        new LockingTree(new int[]{1, 2, 3, -1, 4, -1, 5}).lock(2, 2);
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */