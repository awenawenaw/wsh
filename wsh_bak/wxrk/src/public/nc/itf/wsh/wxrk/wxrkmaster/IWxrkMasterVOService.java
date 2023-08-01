
package nc.itf.wsh.wxrk.wxrkmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

import nc.vo.wxrk.wxrk.AggWxrkMasterVO;
import nc.vo.wxrk.wxrk.WxrkMasterVO;

public interface  IWxrkMasterVOService{

	/**
	 * ��Э�����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggWxrkMasterVO[] listAggWxrkMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��Э�����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggWxrkMasterVO[] listAggWxrkMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��Э�����ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggWxrkMasterVO findAggWxrkMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��Э�����ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggWxrkMasterVO[] listAggWxrkMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��Э�����ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggWxrkMasterVO[] listAggWxrkMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��Э�����ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public WxrkMasterVO[] listWxrkMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��Э�����ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  WxrkMasterVO findWxrkMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��Э�����ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  WxrkMasterVO[] listWxrkMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��Э�����ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  WxrkMasterVO[] listWxrkMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��Э�����ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listWxrkMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��Э�����ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listWxrkMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(WxrkMasterVO vo);
	
	
	/**
	 * Ԥ����������Э�����ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggWxrkMasterVO preAddAggWxrkMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggWxrkMasterVO preAddAggWxrkMasterVO(AggWxrkMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������Э�����ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggWxrkMasterVO preEditAggWxrkMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����Э�����ʵ������
	 * 
	 */
	public AggWxrkMasterVO copyAggWxrkMasterVO(String pk) throws BusinessException;
	/**
	 * ���������Э�����ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggWxrkMasterVO[] saveAggWxrkMasterVO(AggWxrkMasterVO vo) throws BusinessException;

	public AggWxrkMasterVO[] saveAggWxrkMasterVO(AggWxrkMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������Э�����ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggWxrkMasterVO[] deleteAggWxrkMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������Э�����ʵ��
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