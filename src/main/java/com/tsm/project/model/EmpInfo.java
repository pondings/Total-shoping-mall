package com.tsm.project.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "emp_info"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="emp_info", schema="main" )
public class EmpInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="emp_code", length=6)
    private String     empCode      ;

    @Column(name="emp_title", length=10)
    private String     empTitle     ;

    @Column(name="emp_name", length=50)
    private String     empName      ;

    @Column(name="emp_address", length=100)
    private String     empAddress   ;

    @Column(name="emp_email", length=50)
    private String     empEmail     ;

    @Column(name="emp_phone", length=10)
    private String     empPhone     ;

    @Column(name="emp_fax", length=10)
    private String     empFax       ;

    @Column(name="emp_desc", length=100)
    private String     empDesc      ;

    @Column(name="emp_status")
    private Integer    empStatus    ;

    @Column(name="create_by", length=50)
    private String     createBy     ;

    @Temporal(TemporalType.DATE)
    @Column(name="create_date")
    private Date       createDate   ;

    @Column(name="update_by", length=50)
    private String     updateBy     ;

    @Temporal(TemporalType.DATE)
    @Column(name="update_date")
    private Date       updateDate   ;

    @Temporal(TemporalType.DATE)
    @Column(name="emp_date_attended")
    private Date       empDateAttended ;

    @Column(name="emp_position", length=50)
    private String     empPosition  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EmpInfo() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : emp_code ( bpchar ) 
    public void setEmpCode( String empCode ) {
        this.empCode = empCode;
    }
    public String getEmpCode() {
        return this.empCode;
    }

    //--- DATABASE MAPPING : emp_title ( bpchar ) 
    public void setEmpTitle( String empTitle ) {
        this.empTitle = empTitle;
    }
    public String getEmpTitle() {
        return this.empTitle;
    }

    //--- DATABASE MAPPING : emp_name ( bpchar ) 
    public void setEmpName( String empName ) {
        this.empName = empName;
    }
    public String getEmpName() {
        return this.empName;
    }

    //--- DATABASE MAPPING : emp_address ( bpchar ) 
    public void setEmpAddress( String empAddress ) {
        this.empAddress = empAddress;
    }
    public String getEmpAddress() {
        return this.empAddress;
    }

    //--- DATABASE MAPPING : emp_email ( bpchar ) 
    public void setEmpEmail( String empEmail ) {
        this.empEmail = empEmail;
    }
    public String getEmpEmail() {
        return this.empEmail;
    }

    //--- DATABASE MAPPING : emp_phone ( bpchar ) 
    public void setEmpPhone( String empPhone ) {
        this.empPhone = empPhone;
    }
    public String getEmpPhone() {
        return this.empPhone;
    }

    //--- DATABASE MAPPING : emp_fax ( bpchar ) 
    public void setEmpFax( String empFax ) {
        this.empFax = empFax;
    }
    public String getEmpFax() {
        return this.empFax;
    }

    //--- DATABASE MAPPING : emp_desc ( bpchar ) 
    public void setEmpDesc( String empDesc ) {
        this.empDesc = empDesc;
    }
    public String getEmpDesc() {
        return this.empDesc;
    }

    //--- DATABASE MAPPING : emp_status ( int4 ) 
    public void setEmpStatus( Integer empStatus ) {
        this.empStatus = empStatus;
    }
    public Integer getEmpStatus() {
        return this.empStatus;
    }

    //--- DATABASE MAPPING : create_by ( bpchar ) 
    public void setCreateBy( String createBy ) {
        this.createBy = createBy;
    }
    public String getCreateBy() {
        return this.createBy;
    }

    //--- DATABASE MAPPING : create_date ( date ) 
    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }

    //--- DATABASE MAPPING : update_by ( bpchar ) 
    public void setUpdateBy( String updateBy ) {
        this.updateBy = updateBy;
    }
    public String getUpdateBy() {
        return this.updateBy;
    }

    //--- DATABASE MAPPING : update_date ( date ) 
    public void setUpdateDate( Date updateDate ) {
        this.updateDate = updateDate;
    }
    public Date getUpdateDate() {
        return this.updateDate;
    }

    //--- DATABASE MAPPING : emp_date_attended ( date ) 
    public void setEmpDateAttended( Date empDateAttended ) {
        this.empDateAttended = empDateAttended;
    }
    public Date getEmpDateAttended() {
        return this.empDateAttended;
    }

    //--- DATABASE MAPPING : emp_position ( varchar ) 
    public void setEmpPosition( String empPosition ) {
        this.empPosition = empPosition;
    }
    public String getEmpPosition() {
        return this.empPosition;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(empCode);
        sb.append("|");
        sb.append(empTitle);
        sb.append("|");
        sb.append(empName);
        sb.append("|");
        sb.append(empAddress);
        sb.append("|");
        sb.append(empEmail);
        sb.append("|");
        sb.append(empPhone);
        sb.append("|");
        sb.append(empFax);
        sb.append("|");
        sb.append(empDesc);
        sb.append("|");
        sb.append(empStatus);
        sb.append("|");
        sb.append(createBy);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateDate);
        sb.append("|");
        sb.append(empDateAttended);
        sb.append("|");
        sb.append(empPosition);
        return sb.toString(); 
}
}
