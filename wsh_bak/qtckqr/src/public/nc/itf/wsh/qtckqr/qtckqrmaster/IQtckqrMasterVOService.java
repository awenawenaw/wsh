
package nc.itf.wsh.qtckqr.qtckqrmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.qtckqr.qtckqr.AggQtckqrMasterVO;
import nc.vo.qtckqr.qtckqr.QtckqrMasterVO;

public interface  IQtckqrMasterVOService{

	/**
	 * ��������ȷ����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggQtckqrMasterVO[] listAggQtckqrMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggQtckqrMasterVO[] listAggQtckqrMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggQtckqrMasterVO findAggQtckqrMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggQtckqrMasterVO[] listAggQtckqrMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggQtckqrMasterVO[] listAggQtckqrMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public QtckqrMasterVO[] listQtckqrMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  QtckqrMasterVO findQtckqrMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  QtckqrMasterVO[] listQtckqrMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��������ȷ����ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  QtckqrMasterVO[] listQtckqrMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��������ȷ����ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listQtckqrMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��������ȷ����ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listQtckqrMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(QtckqrMasterVO vo);
	
	
	/**
	 * Ԥ����������������ȷ����ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggQtckqrMasterVO preAddAggQtckqrMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggQtckqrMasterVO preAddAggQtckqrMasterVO(AggQtckqrMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������������ȷ����ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggQtckqrMasterVO preEditAggQtckqrMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����������ȷ����ʵ������
	 * 
	 */
	public AggQtckqrMasterVO copyAggQtckqrMasterVO(String pk) throws BusinessException;
	/**
	 * ���������������ȷ����ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggQtckqrMasterVO[] saveAggQtckqrMasterVO(AggQtckqrMasterVO vo) throws BusinessException;

	public AggQtckqrMasterVO[] saveAggQtckqrMasterVO(AggQtckqrMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������������ȷ����ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggQtckqrMasterVO[] deleteAggQtckqrMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������������ȷ����ʵ��
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