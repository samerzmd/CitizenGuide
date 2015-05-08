package com.apps.salta3a.citizenguide.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.salta3a.citizenguide.Fragments.MainSectionFragment;
import com.apps.salta3a.citizenguide.Models.Department;
import com.apps.salta3a.citizenguide.R;

import eu.inmite.android.lib.dialogs.ISimpleDialogListener;
import eu.inmite.android.lib.dialogs.SimpleDialogFragment;

public class DepartmentActivity extends ActionBarActivity implements ISimpleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Department currentDept= getIntent().getExtras().getParcelable(MainSectionFragment.DeptKey);
        TextView aboutDept= (TextView) findViewById(R.id.aboutDept);
        aboutDept.setText(getString(currentDept.desRes));
        setTitle(currentDept.nameRes);

        switch (currentDept.id){
            case 1:
                findViewById(R.id.GAMservicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_gam_image);
                break;

            case 2:
                findViewById(R.id.CIservicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_ci_image);
                break;

            case 3:
                findViewById(R.id.LVservicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_lv_image);
                break;
            case 4:
                findViewById(R.id.permitsServicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_lv_image);
                break;
            case 5:
                findViewById(R.id.irregularitiesServicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_lv_image);
                break;
            case 6:
                findViewById(R.id.professionalLicensingServicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_lv_image);
                break;
            case 7:
                findViewById(R.id.accidentServicesContainer).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.deptImage)).setImageResource(R.drawable.department_lv_image);
                break;
            default:
                Log.wtf("deptActivity", "dept isn't recorded");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_department, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
               finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static final int professionsLicenseClickCode=111;
    public void professionsLicenseClick(View v) {
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.PLTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(professionsLicenseClickCode).show();
    }
    private static final int buildingsTaxClickCode=112;
    public void buildingsTaxClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.buildingTaxTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(buildingsTaxClickCode).show();
    }
    private static final int trafficViolationsClickCode=113;
    public void trafficViolationsClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.trafficViolationsTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(trafficViolationsClickCode).show();
    }
    private static final int bidsClickCode=114;
    public void bidsClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.bidsTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(bidsClickCode).show();
    }
    private static final int complaintClickCode=115;
    public void complaintClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.complaintTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(complaintClickCode).show();
    }
    private static final int recallSubmitClickCode=116;
    public void recallSubmitClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.recallSubmitTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(recallSubmitClickCode).show();
    }

    private static final int issuingBirthClickCode=121;
    public void issuingBirthClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.issuingBirthTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(issuingBirthClickCode).show();
    }
    private static final int issuingMarriageClickCode=122;
    public void issuingMarriageClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.issuingMarriageTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(issuingMarriageClickCode).show();
    }
    private static final int issuingDivorceClickCode=123;
    public void issuingDivorceClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.issuingDivorceTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(issuingDivorceClickCode).show();
    }
    private static final int ratificationDocumentsClickCode=124;
    public void ratificationDocumentsClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.ratificationDocumentsTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(ratificationDocumentsClickCode).show();
    }
    private static final int issuingIDClickCode=125;
    public void issuingIDClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.issuingIDTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(issuingIDClickCode).show();
    }
    private static final int issuingPassportClickCode=126;
    public void issuingPassportClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.issuingPassportTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(issuingPassportClickCode).show();
    }
    private static final int issuingFamilyEnrollmentClickCode=127;
    public void issuingFamilyEnrollmentClick(View v){
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle(R.string.issuingFamilyEnrollmentTitle).setMessage(R.string.DialogMessage).setPositiveButtonText(R.string.uploadForum).setNegativeButtonText(R.string.RequiredDocs).setRequestCode(issuingFamilyEnrollmentClickCode).show();
    }


    public void permitsServicesButtonClick(View v){
        gotoDeptActivity(4);
    }
    public void irregularitiesServicesButtonClick(View v){
        gotoDeptActivity(5);
    }
    public void professionalLicensingServicesButtonClick(View v){
        gotoDeptActivity(6);
    }
    public void accidentServicesButtonClick(View v){
        gotoDeptActivity(7);
    }

    @Override
    public void onPositiveButtonClicked(int i) {
        String url="";
        switch (i){
            case professionsLicenseClickCode:

                break;
            case buildingsTaxClickCode:

                break;
            case trafficViolationsClickCode:

                break;
            case bidsClickCode:

                break;
            case complaintClickCode:

                break;
            case recallSubmitClickCode:

                break;
            case issuingBirthClickCode:

                break;
            case issuingMarriageClickCode:

                break;
            case issuingDivorceClickCode:

                break;
            case ratificationDocumentsClickCode:

                break;
            case issuingIDClickCode:

                break;
            case issuingPassportClickCode:

                break;
            case issuingFamilyEnrollmentClickCode:

                break;
            default:

        }

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (!url.equals(""))
        startActivity(browserIntent);
    }

    @Override
    public void onNegativeButtonClicked(int i) {
        Intent o=new Intent(DepartmentActivity.this,GeneralMessageActivity.class);
        String rawRes;
        switch (i){
            case professionsLicenseClickCode:
                rawRes="required_docs_professions_license.html";
                break;
            case buildingsTaxClickCode:
                rawRes="required_docs_building_tax.html";
                break;
            case trafficViolationsClickCode:
                rawRes="required_docs_traffic_violations.html";
                break;
            case bidsClickCode:
                rawRes="required_docs_bids.html";
                break;
            case complaintClickCode:
                rawRes="required_docs_complaint.html";
                break;
            case recallSubmitClickCode:
                rawRes="required_docs_recall_submit.html";
                break;
            case issuingBirthClickCode:
                rawRes="required_docs_birth.html";
                break;
            case issuingMarriageClickCode:
                rawRes="required_docs_marriage.html";
                break;
            case issuingDivorceClickCode:
                rawRes="required_docs_divorce.html";
                break;
            case ratificationDocumentsClickCode:
                rawRes="required_docs_ratification.html";
                break;
            case issuingIDClickCode:
                rawRes="required_docs_id.html";
                break;
            case issuingPassportClickCode:
                rawRes="required_docs_passport.html";
                break;
            case issuingFamilyEnrollmentClickCode:
                rawRes="required_docs_family_enrollment.html";
                break;
            default:
                rawRes="required_docs_family_enrollment.html";
        }
        o.putExtra(GeneralMessageActivity.messageReskEY,rawRes);
        startActivity(o);
    }

    @Override
    public void onNeutralButtonClicked(int i) {

    }
    private void gotoDeptActivity(int sectionNumber){
        Intent o=new Intent(DepartmentActivity.this,DepartmentActivity.class);
        Department permitDept=new Department(sectionNumber,R.string.LVName,R.string.LVDes);
        o.putExtra(MainSectionFragment.DeptKey,permitDept);
        startActivity(o);
    }
}
