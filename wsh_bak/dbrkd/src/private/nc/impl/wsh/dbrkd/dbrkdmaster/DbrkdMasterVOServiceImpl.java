package nc.impl.wsh.dbrkd.dbrkdmaster;

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


import nc.vo.dbrkd.dbrkd.DbrkdMasterVO;
import nc.vo.dbrkd.dbrkd.DbrkdSlave0VO;
import nc.vo.dbrkd.dbrkd.AggDbrkdMasterVO;
import nc.itf.wsh.dbrkd.dbrkdmaster.IDbrkdMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  DbrkdMasterVOServiceImpl extends ServiceSupport implements IDbrkdMasterVOService {


	@Override
	public AggDbrkdMasterVO[] listAggDbrkdMasterVOByPk(String...pks) throws BusinessException{
		return listAggDbrkdMasterVOByPk(false,pks);
	}

	@Override
	public AggDbrkdMasterVO[] listAggDbrkdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggDbrkdMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggDbrkdMasterVO findAggDbrkdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggDbrkdMasterVO.class, pk, false);
	}

	@Override
	public  AggDbrkdMasterVO[] listAggDbrkdMasterVOByCondition(String condition) throws BusinessException{
		return listAggDbrkdMasterVOByCondition(condition,new String[]{"pk_dbrkdmaster"});
	}
	@Override
	public  AggDbrkdMasterVO[] listAggDbrkdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggDbrkdMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public DbrkdMasterVO[] listDbrkdMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(DbrkdMasterVO.class, pks, true);
	}

	@Override
	public  DbrkdMasterVO findDbrkdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(DbrkdMasterVO.class, pk, true);
	}

	@Override
	public  DbrkdMasterVO[] listDbrkdMasterVOByCondition(String condition) throws BusinessException{
		return listDbrkdMasterVOByCondition(condition,new String[]{"pk_dbrkdmaster"});
	}
	@Override
	public  DbrkdMasterVO[] listDbrkdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(DbrkdMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listDbrkdMasterVOPkByCond(String condition) throws BusinessException{
		return listDbrkdMasterVOPkByCond(condition,new String[]{"pk_dbrkdmaster"});
	}
	@Override
	public String[] listDbrkdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_dbrkdmaster from ").append(DbrkdMasterVO.getDefaultTableName());
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
	public void initDefaultData(DbrkdMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggDbrkdMasterVO preAddAggDbrkdMasterVO(AggDbrkdMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((DbrkdMasterVO)getMainVO(vo));

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
	public AggDbrkdMasterVO preAddAggDbrkdMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggDbrkdMasterVO result = null;

		DbrkdMasterVO mainvo = new DbrkdMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggDbrkdMasterVO aggvo = new AggDbrkdMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggDbrkdMasterVO(result,userJson);
	}

	@Override
	public AggDbrkdMasterVO preEditAggDbrkdMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggDbrkdMasterVO.class, pk, false);
	}

	@Override
	public AggDbrkdMasterVO copyAggDbrkdMasterVO(String pk) throws BusinessException{

		AggDbrkdMasterVO vo = dao.findByPk(AggDbrkdMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		DbrkdSlave0VO[] dbrkdSlave0VOs = (DbrkdSlave0VO[])vo.getChildren(DbrkdSlave0VO.class);
		if(dbrkdSlave0VOs!=null && dbrkdSlave0VOs.length>0){
			Arrays.stream(dbrkdSlave0VOs).forEach(subvo->{
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
	public AggDbrkdMasterVO[] saveAggDbrkdMasterVO(AggDbrkdMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggDbrkdMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggDbrkdMasterVO vo : vos) {
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
	private void setDefaultVal(AggDbrkdMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggDbrkdMasterVO[] saveAggDbrkdMasterVO(AggDbrkdMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggDbrkdMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggDbrkdMasterVO[] deleteAggDbrkdMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggDbrkdMasterVO[] vos = dao.listByPk(AggDbrkdMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggDbrkdMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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
		String cond = " pk_dbrkdmaster = '" + parentId + "' ";
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
