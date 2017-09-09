package com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AuditRecord;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDetails.AccountDetailsActivity;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDisplayAccount;
import com.example.administrator.financialauditingapp.R;

import java.util.List;

import static com.example.administrator.financialauditingapp.R.id.aDAddressTV;
import static com.example.administrator.financialauditingapp.R.id.aDInfoIDTV;
import static com.example.administrator.financialauditingapp.R.id.aDNameTV;

/**
 * Created by Administrator on 5/27/2017.
 */

public class AuditRecordAdapter extends RecyclerView.Adapter<AuditRecordAdapter.AuditRecordHolder> {

    private final String aDViewDetailsTVTEXT = "View Details";
    private final String aDViewAuditRecordTVTEXT = "View Audit Record";
    private AccountDisplayAccount aDAccount;

    private List<AuditRecord> auditRecords;

    private Context mContext;

    public AuditRecordAdapter(Context context, List<AuditRecord> list){
        mContext = context;
        auditRecords = list;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public AuditRecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View accountView = inflater.inflate(R.layout.layout_audit_record,parent,false);
        AuditRecordHolder accountAuditHolder = new AuditRecordHolder(accountView);

        return accountAuditHolder;
    }

    @Override
    public void onBindViewHolder(AuditRecordHolder holder, int position) {
        AuditRecord auditRecord = auditRecords.get(position);

//        aDAccount = auditRecords.get(position);
        TextView aRAuditTypeTV = holder.aRAuditTypeTV;
        TextView aRAuditorNameTV = holder.aRAuditorNameTV;
        TextView aRAuditDateTV = holder.aRAuditDateTV;

        String auditType="", reviewerTitle="";
        switch (auditRecord.operationtype){
            case 0:
                auditType = "Audit Record";
                reviewerTitle = "Submitter";
                break;
            case 1:


        }
        aRAuditTypeTV.setText(auditType);
        aRAuditorNameTV.setText(reviewerTitle + ":" + auditRecord.operatorname);
        aRAuditDateTV.setText("Date Last Reviewed:" + auditRecord.operationtime);
    }

    public static class AuditRecordHolder extends RecyclerView.ViewHolder{

        public TextView aRAuditTypeTV;
        public TextView aRAuditorNameTV;
        public TextView aRAuditDateTV;

        public AuditRecordHolder(View itemView) {
            super(itemView);
            aRAuditTypeTV = (TextView) itemView.findViewById(R.id.aRAuditTypeTV);
            aRAuditorNameTV = (TextView) itemView.findViewById(R.id.aRAuditorNameTV);
            aRAuditDateTV = (TextView) itemView.findViewById(R.id.aRAuditDateTV);
        }
    }

        //    public static  class AccountAuditHolder extends RecyclerView.ViewHolder{
//
//        public TextView aDInfoIDTV;
//        public TextView aDAddressTV;
//        public TextView aDNameTV;
//        public TextView aDViewDetailsTV;
//        public TextView aDViewAuditRecordTV;
//
//        public AccountAuditHolder(View itemView) {
//            super(itemView);
//            aDInfoIDTV = (TextView) itemView.findViewById(R.id.aDInfoIDTV);
//            aDAddressTV = (TextView) itemView.findViewById(R.id.aDAddressTV);
//            aDNameTV = (TextView) itemView.findViewById(R.id.aDNameTV);
//            aDViewDetailsTV = (TextView) itemView.findViewById(R.id.aDDetailsTV);
//            aDViewAuditRecordTV = (TextView) itemView.findViewById(R.id.aDAuditRecordTV);
//        }
//    }
    @Override
    public int getItemCount() {
        return auditRecords.size();
    }



}

