create table if not exists bruker(
BrukerID int not null,
navn varchar(100),
constraint brukerPK primary key (BrukerID)
);
create table if not exists Workout(
NumberID int not null auto_increment,
BrukerID int not null,
varighet double,
PersonligForm int,
prestasjon int,
notat varchar(200),
dato date,
constraint treningsøktPK primary key (NumberID),
constraint treningsøktFK foreign key (BrukerID) references bruker(BrukerID),
constraint check((0<=personligForm)&(personligForm>=10)),
constraint check((0<=prestasjon)&(prestasjon>=10))
);

#øvelse tilhører en workout/treningsøkt
create table if not exists ØtilhørerW(
ØvelseID int not null,
WorkoutID int not null,
constraint ØtilhørerWPK primary key (ØvelseID, WorkoutID),
constraint ØtilhørerWFK1 foreign key (ØvelseID) references Øvelse(ØvelseID),
constraint ØtilhørerWFK2 foreign key (WorkoutID) references Workout(NumberID)
);

create table if not exists Øvelse(
ØvelseID int not null,
Navn varchar(100),
Beskrivelse VARCHAR(255),
ApparatØvelse BOOL not null,
constraint øvelsePK primary key (ØvelseID) 
);

create table if not exists øvelseGruppe(
ØvelsegruppeID int not null,
navn varchar(200),
constraint øvelsegruppePK primary key (ØvelsegruppeID)
);

create table if not exists ØtilhørerG(
ØvelsegruppeID int not null,
ØvelseID int not null,
constraint ØtilhørerGPK primary key (ØvelsegruppeID,ØvelseID),
constraint ØtilhørerGFK1 foreign key (ØvelsegruppeID) references øvelsegruppe(ØvelsegruppeID),
constraint ØtilhørerGFK2 foreign key (ØvelseID) references øvelse(ØvelseID));


create table if not exists apparat(
ApparatID int not null,
navn varchar(100),
brukerBeskrivelse varchar(200),
constraint apparatPK primary key (ApparatID)
);

create table if not exists ØbrukerA(
ApparatID int not null,
ØvelseID int not null,
antallKilo double,
AntallSett int,
constraint ØbrukerAPK primary key (ApparatID,ØvelseID),
constraint ØbrukerAFK1 foreign key (ApparatID) references apparat(ApparatID),
constraint ØbrukerAFK2 foreign key (ØvelseID) references øvelse(ØvelseID)
);
