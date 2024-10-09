CREATE TABLE contact (
    id SERIAL PRIMARY KEY, 
    first_name varchar(100), 
    last_name varchar(200),
    gender varchar(10),
    pseudo varchar(200),
    email varchar(250),
    birth_date date, 
    address varchar(250),
    personal_phone_number varchar(50),
    professionnal_phone_number varchar(50), 
    linkedin_link varchar(250),
    git_link varchar(250)
)