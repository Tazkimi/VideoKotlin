package l.liubin.com.videokotlin.mvp.base

import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by l on 2018/5/8.
 */
abstract class BasePresenter<V, M : BaseModel>(mvpView: V) {
    var mvpView: V? = mvpView
    val mGson: Gson by lazy { Gson() }
    val mModel: M by lazy { createModel() }
    val mDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    abstract fun createModel(): M

    fun detachView() {
        this.mvpView = null
        clearDisposable()
    }

    fun clearDisposable() {
        if (mDisposable.size() != 0) {
            mDisposable.clear()
        }
    }

    fun addDisposable(disposable: Disposable) {
        mDisposable.add(disposable)
    }

}