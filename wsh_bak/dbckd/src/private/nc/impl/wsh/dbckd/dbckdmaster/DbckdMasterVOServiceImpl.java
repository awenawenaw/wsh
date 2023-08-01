package nc.impl.wsh.dbckd.dbckdmaster;

import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.UUID;
import java.lang.String;
import java.util.stream.Stream;
import nc.vo.pub.lang.UFDateTime;
import nc.uap.utils.InSQLCreator;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.beanutils.PropertyUtils;


import nc.vo.pub.BusinessException;
import nc.vo.pub.BusinessRuntimeException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.VOStatus;
import nc.codeplatform.framework.service.ServiceSupport;


import nc.vo.dbckd.dbckd.DbckdSlave0VO;
import nc.vo.dbckd.dbckd.DbckdMasterVO;
import nc.vo.dbckd.dbckd.AggDbckdMasterVO;
import nc.itf.wsh.dbckd.dbckdmaster.IDbckdMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  DbckdMasterVOServiceImpl extends ServiceSupport implements IDbckdMasterVOService {


	@Override
	public AggDbckdMasterVO[] listAggDbckdMasterVOByPk(String...pks) throws BusinessException{
		return listAggDbckdMasterVOByPk(false,pks);
	}

	@Override
	public AggDbckdMasterVO[] listAggDbckdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggDbckdMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggDbckdMasterVO findAggDbckdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggDbckdMasterVO.class, pk, false);
	}

	@Override
	public  AggDbckdMasterVO[] listAggDbckdMasterVOByCondition(String condition) throws BusinessException{
		return listAggDbckdMasterVOByCondition(condition,new String[]{"pk_dbckdmaster"});
	}
	@Override
	public  AggDbckdMasterVO[] listAggDbckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggDbckdMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public DbckdMasterVO[] listDbckdMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(DbckdMasterVO.class, pks, true);
	}

	@Override
	public  DbckdMasterVO findDbckdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(DbckdMasterVO.class, pk, true);
	}

	@Override
	public  DbckdMasterVO[] listDbckdMasterVOByCondition(String condition) throws BusinessException{
		return listDbckdMasterVOByCondition(condition,new String[]{"pk_dbckdmaster"});
	}
	@Override
	public  DbckdMasterVO[] listDbckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(DbckdMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listDbckdMasterVOPkByCond(String condition) throws BusinessException{
		return listDbckdMasterVOPkByCond(condition,new String[]{"pk_dbckdmaster"});
	}
	@Override
	public String[] listDbckdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_dbckdmaster from ").append(DbckdMasterVO.getDefaultTableName());
		sql.append(" where ").append(condition);
		if (ArrayUtils.isNotEmpty(orderPath)) {
			sql.append(" order by ").append(StringUtils.join(orderPath, ", "));
		}
		return (String[]) dao.getBaseDAO().executeQuery(sql.toString(), (rs) -> {
			List<String> pks = new ArrayList<>();
			while (rs.next()) {
				pks.add(rs.getString(1));
			}
			return pks.toArray(new String[0]);
		});
	}
	@Override
	public void initDefaultData(DbckdMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggDbckdMasterVO preAddAggDbckdMasterVO(AggDbckdMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((DbckdMasterVO)getMainVO(vo));

		//�������Ҫ�ж��Ƿ������������
		Map<String,String> data = userJson!=null && userJson.get("data") != null?(Map<String,String>)userJson.get("data"):null;
		if(data!=null && data.size()>0){
			String parentKey = data.get("parentKey");
			String parentPk = data.get("parentPk");
			getMainVO(vo).setAttributeValue(parentKey,parentPk);
		}


		return vo;
	}
	@Override
	public AggDbckdMasterVO preAddAggDbckdMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggDbckdMasterVO result = null;

		DbckdMasterVO mainvo = new DbckdMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggDbckdMasterVO aggvo = new AggDbckdMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggDbckdMasterVO(result,userJson);
	}

	@Override
	public AggDbckdMasterVO preEditAggDbckdMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggDbckdMasterVO.class, pk, false);
	}

	@Override
	public AggDbckdMasterVO copyAggDbckdMasterVO(String pk) throws BusinessException{

		AggDbckdMasterVO vo = dao.findByPk(AggDbckdMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		DbckdSlave0VO[] dbckdSlave0VOs = (DbckdSlave0VO[])vo.getChildren(DbckdSlave0VO.class);
		if(dbckdSlave0VOs!=null && dbckdSlave0VOs.length>0){
			Arrays.stream(dbckdSlave0VOs).forEach(subvo->{
				subvo.setPrimaryKey(null);
				subvo.setStatus(VOStatus.NEW);
				subvo.setAttributeValue("srcbilltype",null);
				subvo.setAttributeValue("srcbillid",null);
				subvo.setAttributeValue("rowno", null);
				subvo.setAttributeValue("srcrowno", null);
			});
		}
		return vo;
	}
	@Override
	public AggDbckdMasterVO[] saveAggDbckdMasterVO(AggDbckdMasterVO vo) throws BusinessException{
		String pk = getVOPrimaryKey(vo);
		setDefaultVal(vo);
		if(StringUtils.isEmpty(pk)){
			return dao.insert(vo); //����
		}else{
			return dao.update(vo); //����
		}
	}
	/**
	 * ����ǰ���������Ϣ
	 * @param vos
	 */
	private void setAuditInfo(AggDbckdMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggDbckdMasterVO vo : vos) {
				String pk = getVOPrimaryKey(vo);
				if(StringUtils.isEmpty(pk)){
					//���ô����˴���ʱ��
					getMainVO(vo).setAttributeValue("creator",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("creationtime",now);
					getMainVO(vo).setAttributeValue("maketime",now);
					getMainVO(vo).setAttributeValue("modifier",null);
					getMainVO(vo).setAttributeValue("modifiedtime",null);
				}else{
					//�����޸����޸�ʱ��
					getMainVO(vo).setAttributeValue("modifier",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("modifiedtime",now);
					getMainVO(vo).setAttributeValue("lastmaketime",now);
				}
			}
		}
	}
	/**
	 * ����ǰ����һЩĬ��ֵ
	 * @param vos
	 */
	private void setDefaultVal(AggDbckdMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggDbckdMasterVO[] saveAggDbckdMasterVO(AggDbckdMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggDbckdMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggDbckdMasterVO[] deleteAggDbckdMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggDbckdMasterVO[] vos = dao.listByPk(AggDbckdMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggDbckdMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

		Boolean isPass = true;
		String error = "";    //������Ϣ
		if(ArrayUtils.isEmpty(vos)){
			isPass = false;
		}
		
		for(int i = 0 ; i < vos.length ; i++){
			SuperVO mainvo = vos[i].getParentVO();
			UFDateTime ts = (UFDateTime)mainvo.getAttributeValue("ts");
			if(!StringUtils.equals(tsMap.get(mainvo.getPrimaryKey()),ts.toString())){
				isPass = false;
				break;
			}
		}
		if(!isPass) {
			throw new BusinessException("�������������ѱ������޸Ļ�ɾ������ˢ�º����ԣ�");
		}
		if(!"".equals(error)){
			throw new BusinessException(error);
		}
	}
	
	@Override
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException{
		String condition = "dr = 0 ";
		return dao.listByCondition(clazz, condition, false);
	}

	@Override
	public String[] queryChildPksByParentId(Class childClazz, String parentId) throws BusinessException{
		String cond = " pk_dbckdmaster = '" + parentId + "' ";
		SuperVO[] vos  = (SuperVO[]) dao.listByCondition(childClazz, cond, false);
		if (vos == null || vos.length == 0) {
			return new String[0];
		}
		return Stream.of(vos).map(vo -> vo.getPrimaryKey()).toArray(String[]::new);
	}


	public SuperVO[] queryChildVOByPks(Class childClazz, String[] pks) throws BusinessException{
		return (SuperVO[]) dao.listByPk(childClazz, pks, false);
	}

}
