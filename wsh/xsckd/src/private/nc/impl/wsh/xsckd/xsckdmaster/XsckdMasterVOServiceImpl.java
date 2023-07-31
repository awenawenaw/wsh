package nc.impl.wsh.xsckd.xsckdmaster;

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


import nc.vo.wsh.xsckd.XsckdMasterVO;
import nc.vo.wsh.xsckd.XsckdSlave0VO;
import nc.vo.wsh.xsckd.AggXsckdMasterVO;
import nc.itf.wsh.xsckd.xsckdmaster.IXsckdMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  XsckdMasterVOServiceImpl extends ServiceSupport implements IXsckdMasterVOService {


	@Override
	public AggXsckdMasterVO[] listAggXsckdMasterVOByPk(String...pks) throws BusinessException{
		return listAggXsckdMasterVOByPk(false,pks);
	}

	@Override
	public AggXsckdMasterVO[] listAggXsckdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggXsckdMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggXsckdMasterVO findAggXsckdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggXsckdMasterVO.class, pk, false);
	}

	@Override
	public  AggXsckdMasterVO[] listAggXsckdMasterVOByCondition(String condition) throws BusinessException{
		return listAggXsckdMasterVOByCondition(condition,new String[]{"pk_xsckdmaster"});
	}
	@Override
	public  AggXsckdMasterVO[] listAggXsckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggXsckdMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public XsckdMasterVO[] listXsckdMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(XsckdMasterVO.class, pks, true);
	}

	@Override
	public  XsckdMasterVO findXsckdMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(XsckdMasterVO.class, pk, true);
	}

	@Override
	public  XsckdMasterVO[] listXsckdMasterVOByCondition(String condition) throws BusinessException{
		return listXsckdMasterVOByCondition(condition,new String[]{"pk_xsckdmaster"});
	}
	@Override
	public  XsckdMasterVO[] listXsckdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(XsckdMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listXsckdMasterVOPkByCond(String condition) throws BusinessException{
		return listXsckdMasterVOPkByCond(condition,new String[]{"pk_xsckdmaster"});
	}
	@Override
	public String[] listXsckdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_xsckdmaster from ").append(XsckdMasterVO.getDefaultTableName());
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
	public void initDefaultData(XsckdMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggXsckdMasterVO preAddAggXsckdMasterVO(AggXsckdMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((XsckdMasterVO)getMainVO(vo));

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
	public AggXsckdMasterVO preAddAggXsckdMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggXsckdMasterVO result = null;

		XsckdMasterVO mainvo = new XsckdMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggXsckdMasterVO aggvo = new AggXsckdMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggXsckdMasterVO(result,userJson);
	}

	@Override
	public AggXsckdMasterVO preEditAggXsckdMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggXsckdMasterVO.class, pk, false);
	}

	@Override
	public AggXsckdMasterVO copyAggXsckdMasterVO(String pk) throws BusinessException{

		AggXsckdMasterVO vo = dao.findByPk(AggXsckdMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		XsckdSlave0VO[] xsckdSlave0VOs = (XsckdSlave0VO[])vo.getChildren(XsckdSlave0VO.class);
		if(xsckdSlave0VOs!=null && xsckdSlave0VOs.length>0){
			Arrays.stream(xsckdSlave0VOs).forEach(subvo->{
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
	public AggXsckdMasterVO[] saveAggXsckdMasterVO(AggXsckdMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggXsckdMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggXsckdMasterVO vo : vos) {
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
	private void setDefaultVal(AggXsckdMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggXsckdMasterVO[] saveAggXsckdMasterVO(AggXsckdMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggXsckdMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggXsckdMasterVO[] deleteAggXsckdMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggXsckdMasterVO[] vos = dao.listByPk(AggXsckdMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggXsckdMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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
		String cond = " pk_xsckdmaster = '" + parentId + "' ";
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
