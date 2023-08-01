
package nc.itf.wsh.cprkd.cprkdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.cprkd.cprkd.AggCprkdMasterVO;
import nc.vo.cprkd.cprkd.CprkdMasterVO;

public interface  ICprkdMasterVOService{

	/**
	 * ��Ʒ��ⵥ��AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggCprkdMasterVO[] listAggCprkdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ��AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggCprkdMasterVO[] listAggCprkdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ��AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggCprkdMasterVO findAggCprkdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ��AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggCprkdMasterVO[] listAggCprkdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ��AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggCprkdMasterVO[] listAggCprkdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public CprkdMasterVO[] listCprkdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  CprkdMasterVO findCprkdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  CprkdMasterVO[] listCprkdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��Ʒ��ⵥ������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  CprkdMasterVO[] listCprkdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��Ʒ��ⵥ������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listCprkdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��Ʒ��ⵥ������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listCprkdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(CprkdMasterVO vo);
	
	
	/**
	 * Ԥ����������Ʒ��ⵥ����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggCprkdMasterVO preAddAggCprkdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggCprkdMasterVO preAddAggCprkdMasterVO(AggCprkdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������Ʒ��ⵥ����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggCprkdMasterVO preEditAggCprkdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����Ʒ��ⵥ����
	 * 
	 */
	public AggCprkdMasterVO copyAggCprkdMasterVO(String pk) throws BusinessException;
	/**
	 * ���������Ʒ��ⵥ����
	 * @param vos �������
	 * @return @
	 */
	public AggCprkdMasterVO[] saveAggCprkdMasterVO(AggCprkdMasterVO vo) throws BusinessException;

	public AggCprkdMasterVO[] saveAggCprkdMasterVO(AggCprkdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������Ʒ��ⵥ����
	 * @param vos ɾ������
	 * @return @
	 */
	public AggCprkdMasterVO[] deleteAggCprkdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݲ�Ʒ��ⵥ
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}