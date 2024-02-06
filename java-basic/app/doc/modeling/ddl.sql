-- 강의실 사진10
DROP TABLE IF EXISTS lms_photos RESTRICT;

-- 강사10
DROP TABLE IF EXISTS lms_teachers RESTRICT;

-- 부서7
DROP TABLE IF EXISTS lms_departments RESTRICT;

-- 교육센터10
DROP TABLE IF EXISTS lms_centers RESTRICT;

-- 강의배정9
DROP TABLE IF EXISTS lms_teacher_lecture RESTRICT;

-- 과정10
DROP TABLE IF EXISTS lms_lectures RESTRICT;

-- 회원3
DROP TABLE IF EXISTS lms_members RESTRICT;

-- 수강신청10
DROP TABLE IF EXISTS lms_apply RESTRICT;

-- 주소10
DROP TABLE IF EXISTS lms_address RESTRICT;

-- 매니저10
DROP TABLE IF EXISTS lms_managers RESTRICT;

-- 학력10
DROP TABLE IF EXISTS lms_level RESTRICT;

-- 강의실10
DROP TABLE IF EXISTS lms_rooms RESTRICT;

-- 학생10
DROP TABLE IF EXISTS lms_students RESTRICT;

-- 강의실 사진10
CREATE TABLE lms_photos (
  photo_no INTEGER      NOT NULL COMMENT '강의실사진번호', -- 강의실사진번호
  filepath VARCHAR(255) NOT NULL COMMENT '사진경로', -- 사진경로
  room_no  INTEGER      NOT NULL COMMENT '강의실번호' -- 강의실번호
)
COMMENT '강의실 사진10';

-- 강의실 사진10
ALTER TABLE lms_photos
  ADD CONSTRAINT PK_lms_photos -- 강의실 사진10 Primary key
  PRIMARY KEY (
  photo_no -- 강의실사진번호
  );

-- 강사10
CREATE TABLE lms_teachers (
  teacher_no INTEGER      NOT NULL COMMENT '강사번호', -- 강사번호
  hour_pay   INTEGER      NULL     COMMENT '시강료', -- 시강료
  photo      VARCHAR(255) NOT NULL COMMENT '사진', -- 사진
  career     VARCHAR(255) NULL     COMMENT '경력' -- 경력
)
COMMENT '강사10';

-- 강사10
ALTER TABLE lms_teachers
  ADD CONSTRAINT PK_lms_teachers -- 강사10 Primary key
  PRIMARY KEY (
  teacher_no -- 강사번호
  );

-- 부서7
CREATE TABLE lms_departments (
  department_no INTEGER     NOT NULL COMMENT '부서번호', -- 부서번호
  title         VARCHAR(60) NOT NULL COMMENT '부서명' -- 부서명
)
COMMENT '부서7';

-- 부서7
ALTER TABLE lms_departments
  ADD CONSTRAINT PK_lms_departments -- 부서7 Primary key
  PRIMARY KEY (
  department_no -- 부서번호
  );

-- 부서7 Unique Index
CREATE UNIQUE INDEX UIX_lms_departments
  ON lms_departments ( -- 부서7
    title ASC -- 부서명
  );

-- 교육센터10
CREATE TABLE lms_centers (
  center_no INTEGER     NOT NULL COMMENT '교육센터번호', -- 교육센터번호
  title     VARCHAR(60) NOT NULL COMMENT '지점명' -- 지점명
)
COMMENT '교육센터10';

-- 교육센터10
ALTER TABLE lms_centers
  ADD CONSTRAINT PK_lms_centers -- 교육센터10 Primary key
  PRIMARY KEY (
  center_no -- 교육센터번호
  );

-- 교육센터10 Unique Index
CREATE UNIQUE INDEX UIX_lms_centers
  ON lms_centers ( -- 교육센터10
    title ASC -- 지점명
  );

-- 강의배정9
CREATE TABLE lms_teacher_lecture (
  lecture_no INTEGER NOT NULL COMMENT '과정번호', -- 과정번호
  teacher_no INTEGER NOT NULL COMMENT '강사번호' -- 강사번호
)
COMMENT '강의배정9';

-- 강의배정9
ALTER TABLE lms_teacher_lecture
  ADD CONSTRAINT PK_lms_teacher_lecture -- 강의배정9 Primary key
  PRIMARY KEY (
  lecture_no, -- 과정번호
  teacher_no  -- 강사번호
  );

-- 과정10
CREATE TABLE lms_lectures (
  lecture_no INTEGER      NOT NULL COMMENT '과정번호', -- 과정번호
  title      VARCHAR(60)  NOT NULL COMMENT '과정명', -- 과정명
  content    VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  qty        INTEGER      NOT NULL COMMENT '모집인원', -- 모집인원
  start_dt   DATE         NOT NULL COMMENT '시작일', -- 시작일
  end_dt     DATE         NOT NULL COMMENT '종료일', -- 종료일
  day_hr     INTEGER      NOT NULL COMMENT '일교육시간', -- 일교육시간
  total_hr   INTEGER      NOT NULL COMMENT '총교육시간', -- 총교육시간
  support    BOOLEAN      NOT NULL COMMENT '국비지원여부', -- 국비지원여부
  room_no    INTEGER      NULL     COMMENT '강의실번호', -- 강의실번호
  manager_no INTEGER      NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '과정10';

-- 과정10
ALTER TABLE lms_lectures
  ADD CONSTRAINT PK_lms_lectures -- 과정10 Primary key
  PRIMARY KEY (
  lecture_no -- 과정번호
  );

-- 회원3
CREATE TABLE lms_members (
  member_no  INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  name       VARCHAR(60) NOT NULL COMMENT '이름', -- 이름
  email      VARCHAR(40) NOT NULL COMMENT '이메일', -- 이메일
  tel        VARCHAR(30) NOT NULL COMMENT '전화', -- 전화
  regster_dt DATE        NULL     DEFAULT (CURDATE()) COMMENT '가입일' -- 가입일
)
COMMENT '회원3';

-- 회원3
ALTER TABLE lms_members
  ADD CONSTRAINT PK_lms_members -- 회원3 Primary key
  PRIMARY KEY (
  member_no -- 회원번호
  );

-- 회원3 Unique Index
CREATE UNIQUE INDEX UIX_lms_members
  ON lms_members ( -- 회원3
    email ASC -- 이메일
  );

-- 회원3 Index
CREATE INDEX IX_lms_members
  ON lms_members( -- 회원3
    name ASC -- 이름
  );

-- 수강신청10
CREATE TABLE lms_apply (
  apply_no    INTEGER  NOT NULL COMMENT '수강신청번호', -- 수강신청번호
  register_dt DATETIME NOT NULL DEFAULT (now()) COMMENT '수강신청일', -- 수강신청일
  state       CHAR(1)  NULL     COMMENT '수강신청상태', -- 수강신청상태
  lecture_no  INTEGER  NOT NULL COMMENT '과정번호', -- 과정번호
  student_no  INTEGER  NOT NULL COMMENT '학생번호' -- 학생번호
)
COMMENT '수강신청10';

-- 수강신청10
ALTER TABLE lms_apply
  ADD CONSTRAINT PK_lms_apply -- 수강신청10 Primary key
  PRIMARY KEY (
  apply_no -- 수강신청번호
  );

-- 주소10
CREATE TABLE lms_address (
  adress_no     INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  postno        VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  basic_address VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소10';

-- 주소10
ALTER TABLE lms_address
  ADD CONSTRAINT PK_lms_address -- 주소10 Primary key
  PRIMARY KEY (
  adress_no -- 주소번호
  );

-- 주소10 Index
CREATE INDEX IX_lms_address
  ON lms_address( -- 주소10
    postno ASC -- 우편번호
  );

-- 매니저10
CREATE TABLE lms_managers (
  manager_no    INTEGER     NOT NULL COMMENT '매니저번호', -- 매니저번호
  position      VARCHAR(60) NULL     COMMENT '직급', -- 직급
  fax           VARCHAR(30) NULL     COMMENT '팩스', -- 팩스
  department_no INTEGER     NOT NULL COMMENT '부서번호' -- 부서번호
)
COMMENT '매니저10';

-- 매니저10
ALTER TABLE lms_managers
  ADD CONSTRAINT PK_lms_managers -- 매니저10 Primary key
  PRIMARY KEY (
  manager_no -- 매니저번호
  );

-- 학력10
CREATE TABLE lms_level (
  level_no INTEGER     NOT NULL COMMENT '학력번호', -- 학력번호
  title    VARCHAR(60) NOT NULL COMMENT '학력명' -- 학력명
)
COMMENT '학력10';

-- 학력10
ALTER TABLE lms_level
  ADD CONSTRAINT PK_lms_level -- 학력10 Primary key
  PRIMARY KEY (
  level_no -- 학력번호
  );

-- 학력10 Unique Index
CREATE UNIQUE INDEX UIX_lms_level
  ON lms_level ( -- 학력10
    title ASC -- 학력명
  );

-- 강의실10
CREATE TABLE lms_rooms (
  room_no   INTEGER     NOT NULL COMMENT '강의실번호', -- 강의실번호
  center_no INTEGER     NOT NULL COMMENT '교육센터번호', -- 교육센터번호
  title     VARCHAR(60) NOT NULL COMMENT '강의실명', -- 강의실명
  qty       INTEGER     NOT NULL COMMENT '수용가능인원' -- 수용가능인원
)
COMMENT '강의실10';

-- 강의실10
ALTER TABLE lms_rooms
  ADD CONSTRAINT PK_lms_rooms -- 강의실10 Primary key
  PRIMARY KEY (
  room_no -- 강의실번호
  );

-- 학생10
CREATE TABLE lms_students (
  student_no     INTEGER      NOT NULL COMMENT '학생번호', -- 학생번호
  jumin          VARCHAR(13)  NULL     COMMENT '주민번호', -- 주민번호
  school         VARCHAR(60)  NULL     COMMENT '학교', -- 학교
  major          VARCHAR(60)  NULL     COMMENT '전공', -- 전공
  detail_address VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  working        BOOLEAN      NOT NULL COMMENT '재직여부', -- 재직여부
  adress_no      INTEGER      NULL     COMMENT '주소번호', -- 주소번호
  level_no       INTEGER      NULL     COMMENT '학력번호' -- 학력번호
)
COMMENT '학생10';

-- 학생10
ALTER TABLE lms_students
  ADD CONSTRAINT PK_lms_students -- 학생10 Primary key
  PRIMARY KEY (
  student_no -- 학생번호
  );

-- 학생10 Unique Index2
CREATE UNIQUE INDEX UIX_lms_students2
  ON lms_students ( -- 학생10
    jumin ASC -- 주민번호
  );

-- 강의실 사진10
ALTER TABLE lms_photos
  ADD CONSTRAINT FK_lms_rooms_TO_lms_photos -- 강의실10 -> 강의실 사진10
  FOREIGN KEY (
  room_no -- 강의실번호
  )
  REFERENCES lms_rooms ( -- 강의실10
  room_no -- 강의실번호
  );

-- 강사10
ALTER TABLE lms_teachers
  ADD CONSTRAINT FK_lms_members_TO_lms_teachers -- 회원3 -> 강사10
  FOREIGN KEY (
  teacher_no -- 강사번호
  )
  REFERENCES lms_members ( -- 회원3
  member_no -- 회원번호
  );

-- 강의배정9
ALTER TABLE lms_teacher_lecture
  ADD CONSTRAINT FK_lms_lectures_TO_lms_teacher_lecture -- 과정10 -> 강의배정9
  FOREIGN KEY (
  lecture_no -- 과정번호
  )
  REFERENCES lms_lectures ( -- 과정10
  lecture_no -- 과정번호
  );

-- 강의배정9
ALTER TABLE lms_teacher_lecture
  ADD CONSTRAINT FK_lms_teachers_TO_lms_teacher_lecture -- 강사10 -> 강의배정9
  FOREIGN KEY (
  teacher_no -- 강사번호
  )
  REFERENCES lms_teachers ( -- 강사10
  teacher_no -- 강사번호
  );

-- 과정10
ALTER TABLE lms_lectures
  ADD CONSTRAINT FK_lms_rooms_TO_lms_lectures -- 강의실10 -> 과정10
  FOREIGN KEY (
  room_no -- 강의실번호
  )
  REFERENCES lms_rooms ( -- 강의실10
  room_no -- 강의실번호
  );

-- 과정10
ALTER TABLE lms_lectures
  ADD CONSTRAINT FK_lms_managers_TO_lms_lectures -- 매니저10 -> 과정10
  FOREIGN KEY (
  manager_no -- 매니저번호
  )
  REFERENCES lms_managers ( -- 매니저10
  manager_no -- 매니저번호
  );

-- 수강신청10
ALTER TABLE lms_apply
  ADD CONSTRAINT FK_lms_lectures_TO_lms_apply -- 과정10 -> 수강신청10
  FOREIGN KEY (
  lecture_no -- 과정번호
  )
  REFERENCES lms_lectures ( -- 과정10
  lecture_no -- 과정번호
  );

-- 수강신청10
ALTER TABLE lms_apply
  ADD CONSTRAINT FK_lms_students_TO_lms_apply -- 학생10 -> 수강신청10
  FOREIGN KEY (
  student_no -- 학생번호
  )
  REFERENCES lms_students ( -- 학생10
  student_no -- 학생번호
  );

-- 매니저10
ALTER TABLE lms_managers
  ADD CONSTRAINT FK_lms_departments_TO_lms_managers -- 부서7 -> 매니저10
  FOREIGN KEY (
  department_no -- 부서번호
  )
  REFERENCES lms_departments ( -- 부서7
  department_no -- 부서번호
  );

-- 매니저10
ALTER TABLE lms_managers
  ADD CONSTRAINT FK_lms_members_TO_lms_managers -- 회원3 -> 매니저10
  FOREIGN KEY (
  manager_no -- 매니저번호
  )
  REFERENCES lms_members ( -- 회원3
  member_no -- 회원번호
  );

-- 강의실10
ALTER TABLE lms_rooms
  ADD CONSTRAINT FK_lms_centers_TO_lms_rooms -- 교육센터10 -> 강의실10
  FOREIGN KEY (
  center_no -- 교육센터번호
  )
  REFERENCES lms_centers ( -- 교육센터10
  center_no -- 교육센터번호
  );

-- 학생10
ALTER TABLE lms_students
  ADD CONSTRAINT FK_lms_address_TO_lms_students -- 주소10 -> 학생10
  FOREIGN KEY (
  adress_no -- 주소번호
  )
  REFERENCES lms_address ( -- 주소10
  adress_no -- 주소번호
  );

-- 학생10
ALTER TABLE lms_students
  ADD CONSTRAINT FK_lms_level_TO_lms_students -- 학력10 -> 학생10
  FOREIGN KEY (
  level_no -- 학력번호
  )
  REFERENCES lms_level ( -- 학력10
  level_no -- 학력번호
  );

-- 학생10
ALTER TABLE lms_students
  ADD CONSTRAINT FK_lms_members_TO_lms_students -- 회원3 -> 학생10
  FOREIGN KEY (
  student_no -- 학생번호
  )
  REFERENCES lms_members ( -- 회원3
  member_no -- 회원번호
  );