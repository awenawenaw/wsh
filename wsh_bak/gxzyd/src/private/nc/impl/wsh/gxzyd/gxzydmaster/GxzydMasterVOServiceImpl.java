package nc.impl.wsh.gxzyd.gxzydmaster;

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


import nc.vo.gxzyd.gxzyd.GxzydMasterVO;
import nc.vo.gxzyd.gxzyd.AggGxzydMasterVO;
import nc.itf.wsh.gxzyd.gxzydmaster.IGxzydMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  GxzydMasterVOServiceImpl extends ServiceSupport implements IGxzydMasterVOService {


	@Override
	public AggGxzydMasterVO[] listAggGxzydMasterVOByPk(String...pks) throws BusinessException{
		return listAggGxzydMasterVOByPk(false,pks);
	}

	@Override
	public AggGxzydMasterVO[] listAggGxzydMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggGxzydMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggGxzydMasterVO findAggGxzydMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggGxzydMasterVO.class, pk, false);
	}

	@Override
	public  AggGxzydMasterVO[] listAggGxzydMasterVOByCondition(String condition) throws BusinessException{
		return listAggGxzydMasterVOByCondition(condition,new String[]{"pk_gxzydmaster"});
	}
	@Override
	public  AggGxzydMasterVO[] listAggGxzydMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggGxzydMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public GxzydMasterVO[] listGxzydMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(GxzydMasterVO.class, pks, true);
	}

	@Override
	public  GxzydMasterVO findGxzydMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(GxzydMasterVO.class, pk, true);
	}

	@Override
	public  GxzydMasterVO[] listGxzydMasterVOByCondition(String condition) throws BusinessException{
		return listGxzydMasterVOByCondition(condition,new String[]{"pk_gxzydmaster"});
	}
	@Override
	public  GxzydMasterVO[] listGxzydMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(GxzydMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listGxzydMasterVOPkByCond(String condition) throws BusinessException{
		return listGxzydMasterVOPkByCond(condition,new String[]{"pk_gxzydmaster"});
	}
	@Override
	public String[] listGxzydMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_gxzydmaster from ").append(GxzydMasterVO.getDefaultTableName());
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
	public void initDefaultData(GxzydMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggGxzydMasterVO preAddAggGxzydMasterVO(AggGxzydMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((GxzydMasterVO)getMainVO(vo));

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
	public AggGxzydMasterVO preAddAggGxzydMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggGxzydMasterVO result = null;

		GxzydMasterVO mainvo = new GxzydMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggGxzydMasterVO aggvo = new AggGxzydMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggGxzydMasterVO(result,userJson);
	}

	@Override
	public AggGxzydMasterVO preEditAggGxzydMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggGxzydMasterVO.class, pk, false);
	}

	@Override
	public AggGxzydMasterVO copyAggGxzydMasterVO(String pk) throws BusinessException{

		AggGxzydMasterVO vo = dao.findByPk(AggGxzydMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		return vo;
	}
	@Override
	public AggGxzydMasterVO[] saveAggGxzydMasterVO(AggGxzydMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggGxzydMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggGxzydMasterVO vo : vos) {
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
	private void setDefaultVal(AggGxzydMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggGxzydMasterVO[] saveAggGxzydMasterVO(AggGxzydMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggGxzydMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggGxzydMasterVO[] deleteAggGxzydMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggGxzydMasterVO[] vos = dao.listByPk(AggGxzydMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggGxzydMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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


}
