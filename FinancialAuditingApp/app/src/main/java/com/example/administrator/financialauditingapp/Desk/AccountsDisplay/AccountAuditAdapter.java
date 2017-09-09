package com.example.administrator.financialauditingapp.Desk.AccountsDisplay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AuditRecord.AuditRecordActivity;
import com.example.administrator.financialauditingapp.Desk.AccountsDisplay.AccountDetails.AccountDetailsActivity;
import com.example.administrator.financialauditingapp.R;

import java.util.List;

public class AccountAuditAdapter extends RecyclerView.Adapter<AccountAuditAdapter.AccountAuditHolder> implements View.OnClickListener{
    private final String aDViewDetailsTVTEXT = "View Details";
    private final String aDViewAuditRecordTVTEXT = "View Audit Record";
    private AccountDisplayAccount aDAccount;

    private List<AccountDisplayAccount> accountDisplayRecyclerList;

    private Context mContext;

    public AccountAuditAdapter(Context context, List<AccountDisplayAccount> list){
        mContext = context;
        accountDisplayRecyclerList = list;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public AccountAuditHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View accountView = inflater.inflate(R.layout.layout_account_display,parent,false);
        AccountAuditHolder accountAuditHolder = new AccountAuditHolder(accountView);

        return accountAuditHolder;
    }

    @Override
    public void onBindViewHolder(AccountAuditHolder holder, int position) {
        AccountDisplayAccount account = accountDisplayRecyclerList.get(position);

        aDAccount = accountDisplayRecyclerList.get(position);

        TextView aDInfoIDTV = holder.aDInfoIDTV;
        TextView aDAddressTV = holder.aDAddressTV;
        TextView aDNameTV = holder.aDNameTV;
        TextView aDViewDetailsTV = holder.aDViewDetailsTV;
        TextView aDViewAuditRecordTV = holder.aDViewAuditRecordTV;

        aDInfoIDTV.setText("ID:" + account.infoid);
        aDAddressTV.setText("Address:" + account.address);
        aDNameTV.setText("Name:"+account.name);
        aDViewDetailsTV.setText(aDViewDetailsTVTEXT);
        aDViewAuditRecordTV.setText(aDViewAuditRecordTVTEXT);

        aDViewDetailsTV.setOnClickListener(this);
        aDViewAuditRecordTV.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return accountDisplayRecyclerList.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aDDetailsTV:
                viewDetails();
                break;
            case R.id.aDAuditRecordTV:
                viewAuditRecord();
                break;

        }
    }

    private void viewAuditRecord() {

        Log.d("VIEW AUDIT RECORD", "ASDASD");
        Intent intent = new Intent(getmContext(), AuditRecordActivity.class);
        intent.putExtra("AUDIT_RECORD",aDAccount);
        mContext.startActivity(intent);
//        Toast.makeText(mContext, "view audit record doesnt do anything yet", Toast.LENGTH_SHORT).show();
//       http://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.detailinfo/2f945727-fb88-49bb-807c-d0383d391930

    }

    private void viewDetails() {

        Log.d("VIEW Details", "upiouio");
        Intent intent = new Intent(getmContext(), AccountDetailsActivity.class);
        intent.putExtra("ACCOUNT_DETAILS",aDAccount);
        mContext.startActivity(intent);
//        Toast.makeText(mContext, "view record doesnt do anything yet", Toast.LENGTH_SHORT).show();
        //Send to this urlhttp://test9.525j.com.cn/finance/financeapi/v1.0/finance.budget.budgetrecord
//
//        {"budgetid":"","employeeid":"e620695b-7537-46d9-8bef-a09900acabd0","infoid":185830,"pageindex":1,"pagesize":2147483647}

    }

    public static  class AccountAuditHolder extends RecyclerView.ViewHolder{

        public TextView aDInfoIDTV;
        public TextView aDAddressTV;
        public TextView aDNameTV;
        public TextView aDViewDetailsTV;
        public TextView aDViewAuditRecordTV;

        public AccountAuditHolder(View itemView) {
            super(itemView);
            aDInfoIDTV = (TextView) itemView.findViewById(R.id.aDInfoIDTV);
            aDAddressTV = (TextView) itemView.findViewById(R.id.aDAddressTV);
            aDNameTV = (TextView) itemView.findViewById(R.id.aDNameTV);
            aDViewDetailsTV = (TextView) itemView.findViewById(R.id.aDDetailsTV);
            aDViewAuditRecordTV = (TextView) itemView.findViewById(R.id.aDAuditRecordTV);
        }
    }
}
