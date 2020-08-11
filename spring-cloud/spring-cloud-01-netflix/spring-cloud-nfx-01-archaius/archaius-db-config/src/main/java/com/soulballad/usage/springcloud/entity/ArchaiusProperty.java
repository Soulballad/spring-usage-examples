package com.soulballad.usage.springcloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : property
 * @since ：2020/5/31 17:22
 */
@Entity
@Table(name = "t_archaius_config")
public class ArchaiusProperty {

    @Id
    private String key;
    @Column(name = "value")
    private String value;
}
