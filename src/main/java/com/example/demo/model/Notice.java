package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "notice_details")
@SequenceGenerator(name = "public.notice_details_notice_id_seq", sequenceName = "public.notice_details_notice_id_seq", initialValue = 1, allocationSize = 1)
public class Notice implements Serializable {

    @Id
    @Column(name = "notice_id")
    @GeneratedValue(generator = "public.notice_details_notice_id_seq", strategy = GenerationType.SEQUENCE)
    private Long noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_beg_dt")
    private LocalDate noticeBegDt;

    @Column(name = "notice_end_dt")
    private LocalDate noticeEndDt;

    @Column(name = "create_dt")
    private LocalDate createDt;

    @Column(name = "update_dt")
    private LocalDate updateDt;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public LocalDate getNoticeBegDt() {
        return noticeBegDt;
    }

    public void setNoticeBegDt(LocalDate noticeBegDt) {
        this.noticeBegDt = noticeBegDt;
    }

    public LocalDate getNoticeEndDt() {
        return noticeEndDt;
    }

    public void setNoticeEndDt(LocalDate noticeEndDt) {
        this.noticeEndDt = noticeEndDt;
    }

    public LocalDate getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDate createDt) {
        this.createDt = createDt;
    }

    public LocalDate getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(LocalDate updateDt) {
        this.updateDt = updateDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return Objects.equals(noticeId, notice.noticeId) && Objects.equals(noticeSummary, notice.noticeSummary) && Objects.equals(noticeDetails, notice.noticeDetails) && Objects.equals(noticeBegDt, notice.noticeBegDt) && Objects.equals(noticeEndDt, notice.noticeEndDt) && Objects.equals(createDt, notice.createDt) && Objects.equals(updateDt, notice.updateDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noticeId, noticeSummary, noticeDetails, noticeBegDt, noticeEndDt, createDt, updateDt);
    }
}
