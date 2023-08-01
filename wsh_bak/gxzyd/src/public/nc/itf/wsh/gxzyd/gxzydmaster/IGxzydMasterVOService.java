
package nc.itf.wsh.gxzyd.gxzydmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.gxzyd.gxzyd.AggGxzydMasterVO;
import nc.vo.gxzyd.gxzyd.GxzydMasterVO;

public interface  IGxzydMasterVOService{

	/**
	 * ����ת�Ƶ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGxzydMasterVO[] listAggGxzydMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ����ת�Ƶ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGxzydMasterVO[] listAggGxzydMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ����ת�Ƶ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggGxzydMasterVO findAggGxzydMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ����ת�Ƶ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggGxzydMasterVO[] listAggGxzydMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ����ת�Ƶ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggGxzydMasterVO[] listAggGxzydMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ����ת�Ƶ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public GxzydMasterVO[] listGxzydMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ����ת�Ƶ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  GxzydMasterVO findGxzydMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ����ת�Ƶ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GxzydMasterVO[] listGxzydMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ����ת�Ƶ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GxzydMasterVO[] listGxzydMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ����ת�Ƶ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGxzydMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ����ת�Ƶ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGxzydMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(GxzydMasterVO vo);
	
	
	/**
	 * Ԥ������������ת�Ƶ�����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGxzydMasterVO preAddAggGxzydMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggGxzydMasterVO preAddAggGxzydMasterVO(AggGxzydMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭��������ת�Ƶ�����
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGxzydMasterVO preEditAggGxzydMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�������ת�Ƶ�����
	 * 
	 */
	public AggGxzydMasterVO copyAggGxzydMasterVO(String pk) throws BusinessException;
	/**
	 * �����������ת�Ƶ�����
	 * @param vos �������
	 * @return @
	 */
	public AggGxzydMasterVO[] saveAggGxzydMasterVO(AggGxzydMasterVO vo) throws BusinessException;

	public AggGxzydMasterVO[] saveAggGxzydMasterVO(AggGxzydMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ����������ת�Ƶ�����
	 * @param vos ɾ������
	 * @return @
	 */
	public AggGxzydMasterVO[] deleteAggGxzydMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݹ���ת�Ƶ�
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}