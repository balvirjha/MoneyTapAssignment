package common;

/**
 * Created by BalvirJha on 29-10-2018.
 */

public interface IBasePresenter<T> {

    void setInteractor(T interactor);

    void start();

    void stop();
}