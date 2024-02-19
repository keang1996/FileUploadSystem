CREATE TABLE document_info (
    id int AUTO_INCREMENT PRIMARY KEY,
    file_name varchar(100),
    file_type varchar(5),
    file_path text,
    created_date datetime not null default current_timestamp
);