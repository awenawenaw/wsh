
package nc.itf.wsh.gxbg.gxbgmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.gxbg.gxbg.AggGxbgMasterVO;
import nc.vo.gxbg.gxbg.GxbgMasterVO;

public interface  IGxbgMasterVOService{

	/**
	 * ���򱨹���ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGxbgMasterVO[] listAggGxbgMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGxbgMasterVO[] listAggGxbgMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggGxbgMasterVO findAggGxbgMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggGxbgMasterVO[] listAggGxbgMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggGxbgMasterVO[] listAggGxbgMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public GxbgMasterVO[] listGxbgMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  GxbgMasterVO findGxbgMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GxbgMasterVO[] listGxbgMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ���򱨹���ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GxbgMasterVO[] listGxbgMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ���򱨹���ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGxbgMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ���򱨹���ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGxbgMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(GxbgMasterVO vo);
	
	
	/**
	 * Ԥ�����������򱨹���ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGxbgMasterVO preAddAggGxbgMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggGxbgMasterVO preAddAggGxbgMasterVO(AggGxbgMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭�������򱨹���ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGxbgMasterVO preEditAggGxbgMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ������򱨹���ʵ������
	 * 
	 */
	public AggGxbgMasterVO copyAggGxbgMasterVO(String pk) throws BusinessException;
	/**
	 * ����������򱨹���ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggGxbgMasterVO[] saveAggGxbgMasterVO(AggGxbgMasterVO vo) throws BusinessException;

	public AggGxbgMasterVO[] saveAggGxbgMasterVO(AggGxbgMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ���������򱨹���ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggGxbgMasterVO[] deleteAggGxbgMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݹ��򱨹���ʵ��
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}