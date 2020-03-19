package mvp;

import contract.Mycontract;
import nuli.MyNuil;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 * Model层
 */
public class MyModel implements Mycontract.iModel {
    @Override
    public void doModelGet(String path, final ModelCallBack callBack) {
        MyNuil.getInstance().doGet(path, new MyNuil.MyCallBack() {
            @Override
            public void onSuccess(String path) {
                callBack.onSuccess(path);
            }

            @Override
            public void onError(String mag) {
                callBack.onError(mag);
            }
        });
    }
}
