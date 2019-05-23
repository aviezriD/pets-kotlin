package com.mx.mascotas.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

abstract class BaseActivity<V : ViewDataBinding, M : BaseViewModel<*,*> > : AppCompatActivity() {
    private lateinit var viewDataBindind : V
    private lateinit var viewModel: M

    @LayoutRes
    abstract fun getIdLayout() : Int

    abstract fun getBindingVariable() : Int

    abstract fun getViewModel() : M

    fun getDataBinding() : V{
        return viewDataBindind
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }


    private fun initDataBinding(){
        viewDataBindind = DataBindingUtil.setContentView(this,getIdLayout())
        viewModel = getViewModel()
        viewDataBindind.setVariable(getBindingVariable(),viewModel)
        viewDataBindind.executePendingBindings()

    }

    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    inline fun FragmentManager.inTransactionNotBack(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.disallowAddToBackStack()
        fragmentTransaction.commit()
    }

    protected fun goFragment(layoutOrign: Int, fragment: Fragment) {
        supportFragmentManager.inTransaction { replace(layoutOrign,fragment) }
    }
    protected fun goFragmentNotBack(layoutOrign: Int, fragment: Fragment) {
        supportFragmentManager.inTransactionNotBack { replace(layoutOrign,fragment) }
    }

}