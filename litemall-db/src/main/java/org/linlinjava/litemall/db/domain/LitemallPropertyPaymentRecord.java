package org.linlinjava.litemall.db.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class LitemallPropertyPaymentRecord {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.house_id
     *
     * @mbg.generated
     */
    private Integer houseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.year
     *
     * @mbg.generated
     */
    private Integer year;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.pay_status
     *
     * @mbg.generated
     */
    private Integer payStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.create_date
     *
     * @mbg.generated
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.paymoney
     *
     * @mbg.generated
     */
    private BigDecimal paymoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_property_payment_record.paymethod
     *
     * @mbg.generated
     */
    private String paymethod;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.id
     *
     * @return the value of litemall_property_payment_record.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.id
     *
     * @param id the value for litemall_property_payment_record.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.house_id
     *
     * @return the value of litemall_property_payment_record.house_id
     *
     * @mbg.generated
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.house_id
     *
     * @param houseId the value for litemall_property_payment_record.house_id
     *
     * @mbg.generated
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.year
     *
     * @return the value of litemall_property_payment_record.year
     *
     * @mbg.generated
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.year
     *
     * @param year the value for litemall_property_payment_record.year
     *
     * @mbg.generated
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.pay_status
     *
     * @return the value of litemall_property_payment_record.pay_status
     *
     * @mbg.generated
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.pay_status
     *
     * @param payStatus the value for litemall_property_payment_record.pay_status
     *
     * @mbg.generated
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.create_date
     *
     * @return the value of litemall_property_payment_record.create_date
     *
     * @mbg.generated
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.create_date
     *
     * @param createDate the value for litemall_property_payment_record.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.paymoney
     *
     * @return the value of litemall_property_payment_record.paymoney
     *
     * @mbg.generated
     */
    public BigDecimal getPaymoney() {
        return paymoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.paymoney
     *
     * @param paymoney the value for litemall_property_payment_record.paymoney
     *
     * @mbg.generated
     */
    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_property_payment_record.paymethod
     *
     * @return the value of litemall_property_payment_record.paymethod
     *
     * @mbg.generated
     */
    public String getPaymethod() {
        return paymethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_property_payment_record.paymethod
     *
     * @param paymethod the value for litemall_property_payment_record.paymethod
     *
     * @mbg.generated
     */
    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_payment_record
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseId=").append(houseId);
        sb.append(", year=").append(year);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", createDate=").append(createDate);
        sb.append(", paymoney=").append(paymoney);
        sb.append(", paymethod=").append(paymethod);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_payment_record
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LitemallPropertyPaymentRecord other = (LitemallPropertyPaymentRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getPaymoney() == null ? other.getPaymoney() == null : this.getPaymoney().equals(other.getPaymoney()))
            && (this.getPaymethod() == null ? other.getPaymethod() == null : this.getPaymethod().equals(other.getPaymethod()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_property_payment_record
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getPaymoney() == null) ? 0 : getPaymoney().hashCode());
        result = prime * result + ((getPaymethod() == null) ? 0 : getPaymethod().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table litemall_property_payment_record
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        houseId("house_id", "houseId", "INTEGER", false),
        year("year", "year", "INTEGER", true),
        payStatus("pay_status", "payStatus", "INTEGER", false),
        createDate("create_date", "createDate", "TIMESTAMP", false),
        paymoney("paymoney", "paymoney", "DECIMAL", false),
        paymethod("paymethod", "paymethod", "VARCHAR", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_property_payment_record
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}