package mvp;

import contract.Mycontract;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 * Present层
 */
public class MyPresent implements Mycontract.iPresent {

    Mycontract.iView iView;
    MyModel myModel;

    public MyPresent(Mycontract.iView view){
        this.iView = view;
        myModel = new MyModel();
    }

    @Override
    public void doPresentGet(String path) {
        myModel.doModelGet(path, new Mycontract.iModel.ModelCallBack() {
            @Override
            public void onSuccess(String path) {
                iView.onSuccess(path);
            }

            @Override
            public void onError(String mag) {
                iView.onError(mag);
            }
        });
    }
}
