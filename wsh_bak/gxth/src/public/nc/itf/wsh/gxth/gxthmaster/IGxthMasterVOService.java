
package nc.itf.wsh.gxth.gxthmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.gxth.gxth.AggGxthMasterVO;
import nc.vo.gxth.gxth.GxthMasterVO;

public interface  IGxthMasterVOService{

	/**
	 * �����˻���ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGxthMasterVO[] listAggGxthMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * �����˻���ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggGxthMasterVO[] listAggGxthMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * �����˻���ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggGxthMasterVO findAggGxthMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * �����˻���ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggGxthMasterVO[] listAggGxthMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * �����˻���ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggGxthMasterVO[] listAggGxthMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * �����˻���ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public GxthMasterVO[] listGxthMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * �����˻���ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  GxthMasterVO findGxthMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * �����˻���ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GxthMasterVO[] listGxthMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * �����˻���ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  GxthMasterVO[] listGxthMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * �����˻���ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGxthMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * �����˻���ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listGxthMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(GxthMasterVO vo);
	
	
	/**
	 * Ԥ�������������˻���ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGxthMasterVO preAddAggGxthMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggGxthMasterVO preAddAggGxthMasterVO(AggGxthMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭���������˻���ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggGxthMasterVO preEditAggGxthMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ��������˻���ʵ������
	 * 
	 */
	public AggGxthMasterVO copyAggGxthMasterVO(String pk) throws BusinessException;
	/**
	 * ������������˻���ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggGxthMasterVO[] saveAggGxthMasterVO(AggGxthMasterVO vo) throws BusinessException;

	public AggGxthMasterVO[] saveAggGxthMasterVO(AggGxthMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ�����������˻���ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggGxthMasterVO[] deleteAggGxthMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݹ����˻���ʵ��
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;

	/**
	 * ��������������ѯ�ӱ�pks
	 * @param childClazz �ӱ�class
	 * @param parentId ��������
	 * @return �ӱ�pks
	 * @throws BusinessException
	 */
	String[] queryChildPksByParentId(Class childClazz, String parentId) throws BusinessException;

	/**
	 * �����ӱ�������ѯ�ӱ�����
	 * @param childClazz �ӱ�class
	 * @param pks �ӱ�
	 * @return �ӱ�vos
	 * @throws BusinessException
	 */
	SuperVO[] queryChildVOByPks(Class childClazz, String[] pks) throws BusinessException;

}