package nc.impl.wsh.lsgyjcd.lsgyjcdmaster;

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


import nc.vo.lsgyjcd.lsgyjcd.LsgyjcdMasterVO;
import nc.vo.lsgyjcd.lsgyjcd.LsgyjcdGxsmVO;
import nc.vo.lsgyjcd.lsgyjcd.AggLsgyjcdMasterVO;
import nc.itf.wsh.lsgyjcd.lsgyjcdmaster.ILsgyjcdMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  LsgyjcdMasterVOServiceImpl extends ServiceSupport implements ILsgyjcdMasterVOService {


	@Override
	public AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByPk(String...pks) throws BusinessException{
		return listAggLsgyjcdMasterVOByPk(false,pks);
	}

	@Override
	public AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggLsgyjcdMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggLsgyjcdMasterVO findAggLsgyjcdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggLsgyjcdMasterVO.class, pk, false);
	}

	@Override
	public  AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByCondition(String condition) throws BusinessException{
		return listAggLsgyjcdMasterVOByCondition(condition,new String[]{"pk_lsgyjcdmaster"});
	}
	@Override
	public  AggLsgyjcdMasterVO[] listAggLsgyjcdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggLsgyjcdMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public LsgyjcdMasterVO[] listLsgyjcdMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(LsgyjcdMasterVO.class, pks, true);
	}

	@Override
	public  LsgyjcdMasterVO findLsgyjcdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(LsgyjcdMasterVO.class, pk, true);
	}

	@Override
	public  LsgyjcdMasterVO[] listLsgyjcdMasterVOByCondition(String condition) throws BusinessException{
		return listLsgyjcdMasterVOByCondition(condition,new String[]{"pk_lsgyjcdmaster"});
	}
	@Override
	public  LsgyjcdMasterVO[] listLsgyjcdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(LsgyjcdMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listLsgyjcdMasterVOPkByCond(String condition) throws BusinessException{
		return listLsgyjcdMasterVOPkByCond(condition,new String[]{"pk_lsgyjcdmaster"});
	}
	@Override
	public String[] listLsgyjcdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_lsgyjcdmaster from ").append(LsgyjcdMasterVO.getDefaultTableName());
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
	public void initDefaultData(LsgyjcdMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggLsgyjcdMasterVO preAddAggLsgyjcdMasterVO(AggLsgyjcdMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((LsgyjcdMasterVO)getMainVO(vo));

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
	public AggLsgyjcdMasterVO preAddAggLsgyjcdMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggLsgyjcdMasterVO result = null;

		LsgyjcdMasterVO mainvo = new LsgyjcdMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggLsgyjcdMasterVO aggvo = new AggLsgyjcdMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggLsgyjcdMasterVO(result,userJson);
	}

	@Override
	public AggLsgyjcdMasterVO preEditAggLsgyjcdMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggLsgyjcdMasterVO.class, pk, false);
	}

	@Override
	public AggLsgyjcdMasterVO copyAggLsgyjcdMasterVO(String pk) throws BusinessException{

		AggLsgyjcdMasterVO vo = dao.findByPk(AggLsgyjcdMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("name",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		LsgyjcdGxsmVO[] lsgyjcdGxsmVOs = (LsgyjcdGxsmVO[])vo.getChildren(LsgyjcdGxsmVO.class);
		if(lsgyjcdGxsmVOs!=null && lsgyjcdGxsmVOs.length>0){
			Arrays.stream(lsgyjcdGxsmVOs).forEach(subvo->{
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
	public AggLsgyjcdMasterVO[] saveAggLsgyjcdMasterVO(AggLsgyjcdMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggLsgyjcdMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggLsgyjcdMasterVO vo : vos) {
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
	private void setDefaultVal(AggLsgyjcdMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggLsgyjcdMasterVO[] saveAggLsgyjcdMasterVO(AggLsgyjcdMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggLsgyjcdMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggLsgyjcdMasterVO[] deleteAggLsgyjcdMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggLsgyjcdMasterVO[] vos = dao.listByPk(AggLsgyjcdMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggLsgyjcdMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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
		String cond = " pk_lsgyjcdmaster = '" + parentId + "' ";
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
