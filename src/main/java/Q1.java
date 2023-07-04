public class Q1 {

    class ClhQueue {
        public void add(Long v){}
        public Long pop(){
            //取出队列元素: 如果CLH无锁队列非空的话
            //seudo code...
            return 0L;
        }

        public boolean isEmpy(){
            return true;
        }
    }

    /** 无锁队列 */
    private ClhQueue clhQueue;

    private static final long BATCH_INC_SIZE = 1000;

    private static final String LOCK_KEY = "HARD_CODE_KEY";
    public Long genSeq(String key, Long value){

        if (!clhQueue.isEmpy()){
            Long take = clhQueue.pop();
            if (take != null) {
                return take;
            }
        }

        //批量积蓄一批自增的id列表
        boolean getLock = beginTxAndLock();
        try {
            Long offset = get(LOCK_KEY);
            if (offset == null){
                offset = 1L;
                set(LOCK_KEY, BATCH_INC_SIZE);
            }
            for (Long k = offset+1; k < offset + BATCH_INC_SIZE; k++) {
                clhQueue.add(k);
            }
            return offset;
        }finally {
            endTx();
        }
    }
    public Long get(String key){
        //seudo impl
        return 0L;
    }

    public void set(String key, Long val){
        //...
    }

    public boolean  beginTxAndLock(){
        return true;
    }

    public void endTx(){
        //release lock and terminate tx
    };


}
