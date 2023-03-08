package io.mosip.idrepository.identity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "idrepo")
public class ExtractionFailTracking {

    @Id
    @SequenceGenerator(name="extraction_seq",sequenceName = "idrepo_extra_fail_tracking")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "extraction_seq")
    @Column(name="sno")
    private long sno;

    @Column(name="uin_hash")
    private String uinHash;

    @Column(name="reg_id")
    private String regId;

    @Column(name="status_code")
    private String statusCode;

    @Column(name="status_comment")
    private String statusComment;

    @Column(name="cr_dtimes")
    private LocalDateTime crDtimes;

}
