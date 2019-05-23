package com.mx.mascotas.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

abstract class BaseFragment<V : ViewDataBinding, M : BaseViewModel<*,*>> : Fragment(){
    private lateinit var viewDataBindind : V
    private lateinit var viewModel: M
    private lateinit var activity: BaseActivity<*,*>
//    lateinit var activityMain: MainActivity
    private lateinit var rootView : View
//    private lateinit var permissions: Permissions

    private fun injectionDagger(){
        //dagger
    }

    abstract fun getIdLayout() : Int

    abstract fun getBindingVariable() : Int

    abstract fun getViewModel() : M

    fun getDataBinding() : V{
        return viewDataBindind
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectionDagger()
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBindind = DataBindingUtil.inflate(inflater,getIdLayout(),container,false)
        rootView = viewDataBindind.root
        return  rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*permissions= Permissions(context,activity)
        if (!permissions.allPermissionsGranted()){
            permissions.getRuntimePermissions()
        }*/
        viewDataBindind.setVariable(getBindingVariable(),viewModel)
        viewDataBindind.executePendingBindings()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*,*>){
            activity = context

        }/*
        if(context is MainActivity)
            activityMain = (getActivity() as MainActivity)*/
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
        getActivity()?.supportFragmentManager?.inTransaction { replace(layoutOrign,fragment) }
    }
    protected fun goFragmentNotBack(layoutOrign: Int, fragment: Fragment) {
        getActivity()?.supportFragmentManager?.inTransactionNotBack { replace(layoutOrign,fragment) }
    }
}