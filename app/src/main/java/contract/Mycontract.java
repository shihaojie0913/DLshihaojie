package contract;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 * 契约统一管理MVP接口
 */
public interface Mycontract {

    interface iView{
        void onSuccess(String json);
        void onError(String mag);
    }

    interface iPresent{
        void doPresentGet(String path);
    }

    interface iModel{
        void doModelGet(String path,ModelCallBack callBack);
        interface ModelCallBack{
            void onSuccess(String path);
            void onError(String mag);
        }
    }



}
