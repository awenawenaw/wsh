 create table WSH_CPRKDMASTER (vdef20 varchar2(101) null /*自定义项20*/,
vdef19 varchar2(101) null /*自定义项19*/,
vdef18 varchar2(101) null /*自定义项18*/,
vdef17 varchar2(101) null /*自定义项17*/,
vdef16 varchar2(101) null /*自定义项16*/,
vdef15 varchar2(101) null /*自定义项15*/,
vdef14 varchar2(101) null /*自定义项14*/,
vdef13 varchar2(101) null /*自定义项13*/,
vdef12 varchar2(101) null /*自定义项12*/,
vdef11 varchar2(101) null /*自定义项11*/,
vdef10 varchar2(101) null /*自定义项10*/,
vdef9 varchar2(101) null /*自定义项9*/,
vdef8 varchar2(101) null /*自定义项8*/,
vdef7 varchar2(101) null /*自定义项7*/,
vdef6 varchar2(101) null /*自定义项6*/,
vdef5 varchar2(101) null /*自定义项5*/,
vdef4 varchar2(101) null /*自定义项4*/,
vdef3 varchar2(101) null /*自定义项3*/,
vdef2 varchar2(101) null /*自定义项2*/,
vdef1 varchar2(101) null /*自定义项1*/,
certifino varchar2(50) null /*合格证号*/,
batchno varchar2(50) null /*批次号*/,
inqty number(28,8) null /*入库数量*/,
position varchar2(20) null /*货位*/,
warehouse varchar2(20) null /*存储地点*/,
invstd varchar2(50) null /*规格*/,
materialname varchar2(50) null /*品名*/,
material varchar2(20) null /*料号*/,
gyjcdcode varchar2(50) null /*工艺进程单号*/,
inwhtime char(19) null /*入库时间*/,
inwhperson varchar2(20) null /*入库人*/,
mobillcode varchar2(50) null /*生产订单号*/,
gyjcdbarcode varchar2(50) null /*工艺进程单条码*/,
name varchar2(50) null /*name*/,
srcrowno varchar2(50) null /*来源行号*/,
rowno varchar2(50) null /*行号*/,
modifiedtime char(19) null /*最后修改时间1*/,
modifier varchar2(20) null /*最后修改人*/,
creationtime char(19) null /*创建时间*/,
creator varchar2(20) null /*创建人*/,
lastmaketime char(19) null /*最后修改时间*/,
maketime char(19) null /*制单时间*/,
pk_org_v varchar2(20) null /*组织多版本*/,
code varchar2(50) null /*完工单号*/,
pk_group varchar2(20) null /*pk_group*/,
pk_org varchar2(20) null /*组织*/,
pk_cprkdmaster char(20) not null /*主键*/,
ts char(19) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') null /*null*/,
dr integer null /*null*/,
 constraint WSH_CPRKDMASTER_PK  primary key (pk_cprkdmaster)
)

/

