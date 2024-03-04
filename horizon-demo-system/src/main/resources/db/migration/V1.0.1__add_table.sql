create table test_flyway
(
    id       int auto_increment,
    a_column int          null,
    b_column VARCHAR(255) null,
    constraint test_flyway_pk
        primary key (id)
);

