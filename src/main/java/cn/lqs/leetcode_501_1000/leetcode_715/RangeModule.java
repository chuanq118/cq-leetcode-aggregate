package cn.lqs.leetcode_715;

import java.util.ArrayList;

class RangeModule {

    private final ArrayList<int[]> ranges;

    public RangeModule() {
      this.ranges = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {
      if(this.ranges.size() == 0){
        this.ranges.add(new int[]{left, right});
        return;
      }
      int idxLeft = binaryFind(left);
      if(idxLeft >= this.ranges.size()){
        if(this.ranges.get(this.ranges.size() - 1)[1] >= left){
          this.ranges.get(this.ranges.size() - 1)[1] = right;
        }else{
          this.ranges.add(new int[]{left, right});
        }
        return;
      }
      int idxRight = binaryFind(right);
      if(idxLeft == 0){
        if(idxRight == 0){
          this.ranges.add(0, new int[]{left, right});
        }else{
          right = Math.max(this.ranges.get(idxRight - 1)[1], right);
          for(int i = 0; i < idxRight; i++){
            this.ranges.remove(0);
          }
          this.ranges.add(0, new int[]{left, right});
        }
        return;
      }

       
    }
    
    public boolean queryRange(int left, int right) {
        return false;
    }
    
    public void removeRange(int left, int right) {

    }

    private int binaryFind(int num){
      int r = this.ranges.size() - 1;
      int l = 0;
      while(l <= r){
        int mid = (l + r) >> 1;
        int midVal = this.ranges.get(mid)[0];
        if(midVal <= num){
          l = mid + 1;
        }else if (midVal > num){
          r = mid - 1;
        }
      }
      return l;
    }

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */