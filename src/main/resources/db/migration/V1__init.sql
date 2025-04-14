CREATE TABLE categories
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      BIGINT NULL,
    last_updated_at BIGINT NULL,
    name            VARCHAR(255) NULL,
    value           VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE join_instructor
(
    user_id        BIGINT NOT NULL,
    specialization VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_join_instructor PRIMARY KEY (user_id)
);

CREATE TABLE join_mentor
(
    user_id BIGINT NOT NULL,
    company VARCHAR(255) NULL,
    CONSTRAINT pk_join_mentor PRIMARY KEY (user_id)
);

CREATE TABLE join_ta
(
    user_id            BIGINT NOT NULL,
    number_of_sessions INT    NOT NULL,
    CONSTRAINT pk_join_ta PRIMARY KEY (user_id)
);

CREATE TABLE join_user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_join_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    company  VARCHAR(255) NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT NOT NULL,
    CONSTRAINT pk_msc_ta_ PRIMARY KEY (id)
);

CREATE TABLE products
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      BIGINT NULL,
    last_updated_at BIGINT NULL,
    title           VARCHAR(100) NULL,
    price DOUBLE NULL,
    category_id     BIGINT NULL,
    `description`   VARCHAR(255) NULL,
    image           VARCHAR(255) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE single_table_user
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    user_type          INT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT NOT NULL,
    specialization     VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    company            VARCHAR(255) NULL,
    CONSTRAINT pk_singletable_user PRIMARY KEY (id)
);

CREATE TABLE table_per_class_instructor
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_table_per_class_instructor PRIMARY KEY (id)
);

CREATE TABLE table_per_class_mentor
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    company  VARCHAR(255) NULL,
    CONSTRAINT pk_table_per_class_mentor PRIMARY KEY (id)
);

CREATE TABLE table_per_class_ta
(
    id                 BIGINT NOT NULL,
    name               VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    number_of_sessions INT    NOT NULL,
    CONSTRAINT pk_table_per_class_ta PRIMARY KEY (id)
);

CREATE TABLE table_per_class_user
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_table_per_class_user PRIMARY KEY (id)
);

ALTER TABLE join_instructor
    ADD CONSTRAINT FK_JOIN_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE join_mentor
    ADD CONSTRAINT FK_JOIN_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE join_ta
    ADD CONSTRAINT FK_JOIN_TA_ON_USER FOREIGN KEY (user_id) REFERENCES join_user (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);