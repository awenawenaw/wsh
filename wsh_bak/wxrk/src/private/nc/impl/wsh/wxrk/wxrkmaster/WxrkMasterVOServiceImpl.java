package nc.impl.wsh.wxrk.wxrkmaster;

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


import nc.vo.wxrk.wxrk.WxrkSlave0VO;
import nc.vo.wxrk.wxrk.WxrkMasterVO;
import nc.vo.wxrk.wxrk.AggWxrkMasterVO;
import nc.itf.wsh.wxrk.wxrkmaster.IWxrkMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  WxrkMasterVOServiceImpl extends ServiceSupport implements IWxrkMasterVOService {


	@Override
	public AggWxrkMasterVO[] listAggWxrkMasterVOByPk(String...pks) throws BusinessException{
		return listAggWxrkMasterVOByPk(false,pks);
	}

	@Override
	public AggWxrkMasterVO[] listAggWxrkMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggWxrkMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggWxrkMasterVO findAggWxrkMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggWxrkMasterVO.class, pk, false);
	}

	@Override
	public  AggWxrkMasterVO[] listAggWxrkMasterVOByCondition(String condition) throws BusinessException{
		return listAggWxrkMasterVOByCondition(condition,new String[]{"pk_wxrkmaster"});
	}
	@Override
	public  AggWxrkMasterVO[] listAggWxrkMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggWxrkMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public WxrkMasterVO[] listWxrkMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(WxrkMasterVO.class, pks, true);
	}

	@Override
	public  WxrkMasterVO findWxrkMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(WxrkMasterVO.class, pk, true);
	}

	@Override
	public  WxrkMasterVO[] listWxrkMasterVOByCondition(String condition) throws BusinessException{
		return listWxrkMasterVOByCondition(condition,new String[]{"pk_wxrkmaster"});
	}
	@Override
	public  WxrkMasterVO[] listWxrkMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(WxrkMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listWxrkMasterVOPkByCond(String condition) throws BusinessException{
		return listWxrkMasterVOPkByCond(condition,new String[]{"pk_wxrkmaster"});
	}
	@Override
	public String[] listWxrkMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_wxrkmaster from ").append(WxrkMasterVO.getDefaultTableName());
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
	public void initDefaultData(WxrkMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggWxrkMasterVO preAddAggWxrkMasterVO(AggWxrkMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((WxrkMasterVO)getMainVO(vo));

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
	public AggWxrkMasterVO preAddAggWxrkMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggWxrkMasterVO result = null;

		WxrkMasterVO mainvo = new WxrkMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggWxrkMasterVO aggvo = new AggWxrkMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggWxrkMasterVO(result,userJson);
	}

	@Override
	public AggWxrkMasterVO preEditAggWxrkMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggWxrkMasterVO.class, pk, false);
	}

	@Override
	public AggWxrkMasterVO copyAggWxrkMasterVO(String pk) throws BusinessException{

		AggWxrkMasterVO vo = dao.findByPk(AggWxrkMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		WxrkSlave0VO[] wxrkSlave0VOs = (WxrkSlave0VO[])vo.getChildren(WxrkSlave0VO.class);
		if(wxrkSlave0VOs!=null && wxrkSlave0VOs.length>0){
			Arrays.stream(wxrkSlave0VOs).forEach(subvo->{
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
	public AggWxrkMasterVO[] saveAggWxrkMasterVO(AggWxrkMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggWxrkMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggWxrkMasterVO vo : vos) {
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
	private void setDefaultVal(AggWxrkMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggWxrkMasterVO[] saveAggWxrkMasterVO(AggWxrkMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggWxrkMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggWxrkMasterVO[] deleteAggWxrkMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggWxrkMasterVO[] vos = dao.listByPk(AggWxrkMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggWxrkMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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
		String cond = " pk_wxrkmaster = '" + parentId + "' ";
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
