/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/10/17 19:27:41                          */
/*==============================================================*/


drop table if exists alleviation_result;

drop table if exists alleviation_situation;

drop table if exists applicant_info;

drop table if exists dictionary;

drop table if exists message_info;

drop table if exists poor_demand_condition;

drop table if exists poor_demand_item;

drop table if exists poverty_measure;

drop table if exists poverty_plan;

drop table if exists selection_notes;

drop table if exists user;

/*==============================================================*/
/* Table: alleviation_result                                    */
/*==============================================================*/
create table alleviation_result
(
   alleviationResultID  int not null auto_increment,
   applicantID          int,
   registrant           varchar(20),
   alleviationStartTime2 varchar(20),
   resultDescription    varchar(50),
   registerTime         varchar(20),
   alleviationEndTime2  varchar(20),
   alleviationStatus    varchar(20),
   primary key (alleviationResultID)
);

/*==============================================================*/
/* Table: alleviation_situation                                 */
/*==============================================================*/
create table alleviation_situation
(
   alleviationSituationID int not null auto_increment,
   applicantID          int,
   startTime            varchar(20),
   alleviationDetail    text,
   alleviationDelete    int,
   endTime              varchar(20),
   primary key (alleviationSituationID)
);

/*==============================================================*/
/* Table: applicant_info                                        */
/*==============================================================*/
create table applicant_info
(
   applicantID          int not null auto_increment,
   applicantName        varchar(20),
   applicantSex         varchar(10),
   applicantNation      varchar(20),
   applicantIdNumber    varchar(30),
   applicantDisabilityNumber varchar(30),
   applicantAddress     varchar(50),
   applicantFamilyNumber int,
   applicantDisablityCondition varchar(50),
   applicantPhone       varchar(30),
   applicantIncome      int,
   houseArea            float,
   education            varchar(20),
   marriage             varchar(20),
   applicationTime      varchar(30),
   povertyRank          varchar(20),
   applicantStatus      int,
   bankCardNumber       varchar(20),
   applicantReason      varchar(100),
   primary key (applicantID)
);

/*==============================================================*/
/* Table: dictionary                                            */
/*==============================================================*/
create table dictionary
(
   dicID                int not null auto_increment,
   dicName              varchar(50),
   dicType              varchar(15),
   dicDescription       varchar(100),
   primary key (dicID)
);

/*==============================================================*/
/* Table: message_info                                          */
/*==============================================================*/
create table message_info
(
   message_id           int not null auto_increment,
   message_content      varchar(80),
   message_time         varchar(30),
   message_peo          varchar(20),
   message_status       int,
   primary key (message_id)
);

/*==============================================================*/
/* Table: poor_demand_condition                                 */
/*==============================================================*/
create table poor_demand_condition
(
   poorDemandConditionID int not null auto_increment,
   demandID             int,
   applicantID          int,
   primary key (poorDemandConditionID)
);

/*==============================================================*/
/* Table: poor_demand_item                                      */
/*==============================================================*/
create table poor_demand_item
(
   demandID             int not null auto_increment,
   demandName           varchar(20),
   demandDescription    varchar(40),
   poorDemandItemStatus int,
   primary key (demandID)
);

/*==============================================================*/
/* Table: poverty_measure                                       */
/*==============================================================*/
create table poverty_measure
(
   measureID            int not null auto_increment,
   planID               int,
   measureName          varchar(20),
   poorNumber           int,
   poorVillage          varchar(20),
   budgetAmount         double,
   measureContent       varchar(50),
   primary key (measureID)
);

/*==============================================================*/
/* Table: poverty_plan                                          */
/*==============================================================*/
create table poverty_plan
(
   planID               int not null auto_increment,
   planName             varchar(20),
   planTime             varchar(20),
   planContent          varchar(50),
   planMaker            varchar(20),
   planTotalMoney       double,
   planAim              varchar(40),
   planPredictTime      varchar(20),
   planStartTime        varchar(20),
   planStatus           varchar(10),
   primary key (planID)
);

/*==============================================================*/
/* Table: selection_notes                                       */
/*==============================================================*/
create table selection_notes
(
   selectionNotesID     int not null auto_increment,
   notesName            varchar(50),
   applyStartTime       varchar(30),
   applyEndTime         varchar(30),
   applyContent         varchar(200),
   applyPerson          varchar(20),
   applyTime            varchar(50),
   applyStatus          int,
   primary key (selectionNotesID)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userID               int not null auto_increment,
   userName             varchar(30) not null,
   userPassword         varchar(30) not null,
   userStatus           int,
   userTrueName         varchar(20),
   userSex              varchar(2),
   IDCard               varchar(20),
   userPhone            varchar(15),
   userAddr             varchar(50),
   primary key (userID)
);

alter table alleviation_result add constraint FK_Relationship_7 foreign key (applicantID)
      references applicant_info (applicantID) on delete restrict on update restrict;

alter table alleviation_situation add constraint FK_Relationship_8 foreign key (applicantID)
      references applicant_info (applicantID) on delete restrict on update restrict;

alter table poor_demand_condition add constraint FK_Relationship_5 foreign key (demandID)
      references poor_demand_item (demandID) on delete restrict on update restrict;

alter table poor_demand_condition add constraint FK_Relationship_6 foreign key (applicantID)
      references applicant_info (applicantID) on delete restrict on update restrict;

alter table poverty_measure add constraint FK_Relationship_4 foreign key (planID)
      references poverty_plan (planID) on delete restrict on update restrict;

