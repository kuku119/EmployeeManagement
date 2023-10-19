# Java

## JDK:
- Version 1.8


# DATABASE

## MySQL:
- Version 8.0


## Databases:
- employee_management


## Tables:

### Department
- bigint id
- timestamp create_time
- timestamp update_time
- int department_id
- varchar name


### Employee
- bigint id
- timestamp create_time
- timestamp update_time
- int employee_id
- varchar name
- varchar email
- int gender
- date birthday
- int department


### User
- bigint id
- timestamp create_time
- timestamp update_time
- varchar username
- varchar password
- tinyint permission
  - select: 0001 (1)
  - insert: 0010 (2)
  - update: 0100 (4)
  - delete: 1000 (8)
