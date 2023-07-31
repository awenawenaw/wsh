
package nc.itf.wsh.hwtzd.hwtzdmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.hwtzd.hwtzd.AggHwtzdMasterVO;
import nc.vo.hwtzd.hwtzd.HwtzdMasterVO;

public interface  IHwtzdMasterVOService{

	/**
	 * ��λ������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggHwtzdMasterVO[] listAggHwtzdMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��λ������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggHwtzdMasterVO[] listAggHwtzdMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��λ������ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggHwtzdMasterVO findAggHwtzdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��λ������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggHwtzdMasterVO[] listAggHwtzdMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��λ������ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggHwtzdMasterVO[] listAggHwtzdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��λ������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public HwtzdMasterVO[] listHwtzdMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��λ������ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  HwtzdMasterVO findHwtzdMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��λ������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  HwtzdMasterVO[] listHwtzdMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��λ������ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  HwtzdMasterVO[] listHwtzdMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��λ������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listHwtzdMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��λ������ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listHwtzdMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(HwtzdMasterVO vo);
	
	
	/**
	 * Ԥ����������λ������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggHwtzdMasterVO preAddAggHwtzdMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggHwtzdMasterVO preAddAggHwtzdMasterVO(AggHwtzdMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������λ������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggHwtzdMasterVO preEditAggHwtzdMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����λ������ʵ������
	 * 
	 */
	public AggHwtzdMasterVO copyAggHwtzdMasterVO(String pk) throws BusinessException;
	/**
	 * ���������λ������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggHwtzdMasterVO[] saveAggHwtzdMasterVO(AggHwtzdMasterVO vo) throws BusinessException;

	public AggHwtzdMasterVO[] saveAggHwtzdMasterVO(AggHwtzdMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������λ������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggHwtzdMasterVO[] deleteAggHwtzdMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * �������������ݻ�λ������ʵ��
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