 create table WSH_DBCKDSLAVE0 (def30 varchar2(101) null /*自定义项30*/,
def29 varchar2(101) null /*自定义项29*/,
def28 varchar2(101) null /*自定义项28*/,
def27 varchar2(101) null /*自定义项27*/,
def26 varchar2(101) null /*自定义项26*/,
def25 varchar2(101) null /*自定义项25*/,
def24 varchar2(101) null /*自定义项24*/,
def23 varchar2(101) null /*自定义项23*/,
def22 varchar2(101) null /*自定义项22*/,
def21 varchar2(101) null /*自定义项21*/,
def20 varchar2(101) null /*自定义项20*/,
def19 varchar2(101) null /*自定义项19*/,
def18 varchar2(101) null /*自定义项18*/,
def17 varchar2(101) null /*自定义项17*/,
def16 varchar2(101) null /*自定义项16*/,
def15 varchar2(101) null /*自定义项15*/,
def14 varchar2(101) null /*自定义项14*/,
def13 varchar2(101) null /*自定义项13*/,
def12 varchar2(101) null /*自定义项12*/,
def11 varchar2(101) null /*自定义项11*/,
def10 varchar2(101) null /*自定义项10*/,
def9 varchar2(101) null /*自定义项9*/,
def8 varchar2(101) null /*自定义项8*/,
def7 varchar2(101) null /*自定义项7*/,
def6 varchar2(101) null /*自定义项6*/,
def5 varchar2(101) null /*自定义项5*/,
def4 varchar2(101) null /*自定义项4*/,
def3 varchar2(101) null /*自定义项3*/,
def2 varchar2(101) null /*自定义项2*/,
def1 varchar2(101) null /*自定义项1*/,
batchno varchar2(50) null /*批次号*/,
dcnum number(28,8) null /*调出数量*/,
sq number(28,8) null /*申请数量*/,
dchw varchar2(20) null /*调出货位*/,
xh varchar2(50) null /*型号*/,
stec varchar2(50) null /*规格*/,
matrailid varchar2(20) null /*物料*/,
srcrowno varchar2(50) null /*来源行号*/,
rowno varchar2(50) null /*行号*/,
pk_dbckdslave0 char(20) not null /*主键*/,
pk_dbckdmaster char(20) not null /*上层单据主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint WSH_DBCKDSLAVE0_PK  primary key (pk_dbckdslave0)
)

/

 create table WSH_DBCKDMASTER (def30 varchar2(101) null /*自定义项30*/,
def29 varchar2(101) null /*自定义项29*/,
def28 varchar2(101) null /*自定义项28*/,
def27 varchar2(101) null /*自定义项27*/,
def26 varchar2(101) null /*自定义项26*/,
def25 varchar2(101) null /*自定义项25*/,
def24 varchar2(101) null /*自定义项24*/,
def23 varchar2(101) null /*自定义项23*/,
def22 varchar2(101) null /*自定义项22*/,
def21 varchar2(101) null /*自定义项21*/,
def20 varchar2(101) null /*自定义项20*/,
def19 varchar2(101) null /*自定义项19*/,
def18 varchar2(101) null /*自定义项18*/,
def17 varchar2(101) null /*自定义项17*/,
def16 varchar2(101) null /*自定义项16*/,
def15 varchar2(101) null /*自定义项15*/,
def14 varchar2(101) null /*自定义项14*/,
def13 varchar2(101) null /*自定义项13*/,
def12 varchar2(101) null /*自定义项12*/,
def11 varchar2(101) null /*自定义项11*/,
def10 varchar2(101) null /*自定义项10*/,
def9 varchar2(101) null /*自定义项9*/,
def8 varchar2(101) null /*自定义项8*/,
def7 varchar2(101) null /*自定义项7*/,
def6 varchar2(101) null /*自定义项6*/,
def5 varchar2(101) null /*自定义项5*/,
def4 varchar2(101) null /*自定义项4*/,
def3 varchar2(101) null /*自定义项3*/,
def2 varchar2(101) null /*自定义项2*/,
def1 varchar2(101) null /*自定义项1*/,
bz varchar2(200) null /*备注*/,
dcck varchar2(20) null /*调出仓库id*/,
ccksj char(19) null /*出库时间*/,
ckr varchar2(20) null /*出库人*/,
dbsqdid varchar2(50) null /*调拨申请单id*/,
ddbssqd varchar2(50) null /*调拨申请单单号*/,
dbsqd varchar2(50) null /*调拨申请单扫描框*/,
modifiedtime char(19) null /*最后修改时间1*/,
modifier varchar2(20) null /*最后修改人*/,
creationtime char(19) null /*创建时间*/,
creator varchar2(20) null /*创建人*/,
lastmaketime char(19) null /*最后修改时间*/,
maketime char(19) null /*制单时间*/,
pk_org_v varchar2(20) null /*组织多版本*/,
code varchar2(50) null /*调拨出库单号*/,
pk_group varchar2(20) null /*pk_group*/,
pk_org varchar2(20) null /*pk_org*/,
pk_dbckdmaster char(20) not null /*主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint WSH_DBCKDMASTER_PK  primary key (pk_dbckdmaster)
)

/
