package nc.impl.wsh.qcysdgxwx.qcysdgxwxmaster;

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


import nc.vo.qcysdgxwx.qcysdgxwx.QcysdgxwxMasterVO;
import nc.vo.qcysdgxwx.qcysdgxwx.AggQcysdgxwxMasterVO;
import nc.itf.wsh.qcysdgxwx.qcysdgxwxmaster.IQcysdgxwxMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  QcysdgxwxMasterVOServiceImpl extends ServiceSupport implements IQcysdgxwxMasterVOService {


	@Override
	public AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByPk(String...pks) throws BusinessException{
		return listAggQcysdgxwxMasterVOByPk(false,pks);
	}

	@Override
	public AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggQcysdgxwxMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggQcysdgxwxMasterVO findAggQcysdgxwxMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggQcysdgxwxMasterVO.class, pk, false);
	}

	@Override
	public  AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByCondition(String condition) throws BusinessException{
		return listAggQcysdgxwxMasterVOByCondition(condition,new String[]{"pk_qcysdmaster"});
	}
	@Override
	public  AggQcysdgxwxMasterVO[] listAggQcysdgxwxMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggQcysdgxwxMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public QcysdgxwxMasterVO[] listQcysdgxwxMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(QcysdgxwxMasterVO.class, pks, true);
	}

	@Override
	public  QcysdgxwxMasterVO findQcysdgxwxMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(QcysdgxwxMasterVO.class, pk, true);
	}

	@Override
	public  QcysdgxwxMasterVO[] listQcysdgxwxMasterVOByCondition(String condition) throws BusinessException{
		return listQcysdgxwxMasterVOByCondition(condition,new String[]{"pk_qcysdmaster"});
	}
	@Override
	public  QcysdgxwxMasterVO[] listQcysdgxwxMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(QcysdgxwxMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listQcysdgxwxMasterVOPkByCond(String condition) throws BusinessException{
		return listQcysdgxwxMasterVOPkByCond(condition,new String[]{"pk_qcysdmaster"});
	}
	@Override
	public String[] listQcysdgxwxMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_qcysdmaster from ").append(QcysdgxwxMasterVO.getDefaultTableName());
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
	public void initDefaultData(QcysdgxwxMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
	}
	@Override
	public AggQcysdgxwxMasterVO preAddAggQcysdgxwxMasterVO(AggQcysdgxwxMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((QcysdgxwxMasterVO)getMainVO(vo));

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
	public AggQcysdgxwxMasterVO preAddAggQcysdgxwxMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggQcysdgxwxMasterVO result = null;

		QcysdgxwxMasterVO mainvo = new QcysdgxwxMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggQcysdgxwxMasterVO aggvo = new AggQcysdgxwxMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggQcysdgxwxMasterVO(result,userJson);
	}

	@Override
	public AggQcysdgxwxMasterVO preEditAggQcysdgxwxMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggQcysdgxwxMasterVO.class, pk, false);
	}

	@Override
	public AggQcysdgxwxMasterVO copyAggQcysdgxwxMasterVO(String pk) throws BusinessException{

		AggQcysdgxwxMasterVO vo = dao.findByPk(AggQcysdgxwxMasterVO.class, pk, false);

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
	public AggQcysdgxwxMasterVO[] saveAggQcysdgxwxMasterVO(AggQcysdgxwxMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggQcysdgxwxMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggQcysdgxwxMasterVO vo : vos) {
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
	private void setDefaultVal(AggQcysdgxwxMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggQcysdgxwxMasterVO[] saveAggQcysdgxwxMasterVO(AggQcysdgxwxMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggQcysdgxwxMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggQcysdgxwxMasterVO[] deleteAggQcysdgxwxMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggQcysdgxwxMasterVO[] vos = dao.listByPk(AggQcysdgxwxMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggQcysdgxwxMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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
