package com.future.zhh.ticket.domain.interactor;

import com.future.zhh.ticket.data.repository.CommonRepository;
import com.future.zhh.ticket.domain.executor.PostExecutionThread;
import com.future.zhh.ticket.domain.executor.ThreadExecutor;
import com.future.zhh.ticket.domain.interactor.base.Case;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Administrator on 2017/11/28.
 */

public class OrderMsgByOrderID extends Case {
    private CommonRepository repository;
    private String  orderID;
    @Inject
    public OrderMsgByOrderID(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                CommonRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository=repository;
    }
    public void setData(String orderID){
        this.orderID = orderID;

    }
    @Override
    protected Observable buildCaseObservable() {
        return repository.orderMsgByOrderID(orderID);
    }
}
