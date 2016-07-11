package cn.xiezhaoxin.common.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableVO<T1 extends BaseBean, T2 extends BaseVO> {
	private Page<T1> page;
	private ModelConvertor<T1, T2> convert;
	
	

	public <P> PageableVO(Page<T1> page, ModelConvertor<T1, T2> convert) {
		this.page = page;
		this.convert = convert;
	}

	/**
	 * Returns the number of elements currently on this page.
	 * 
	 * @return the number of elements currently on this page.
	 */
	public int getNumber() {
		return page.getNumberOfElements();
	}

	/**
	 * Returns the total amount of elements.
	 * 
	 * @return the total amount of elements.
	 */
	public long getTotal() {
		return page.getTotalElements();
	}

	/**
	 * Returns the number of total pages.
	 * 
	 * @return the number of total pages.
	 */
	public int getTotalPages() {
		return page.getTotalPages();
	}

	/**
	 * Returns the page content as List.
	 * 
	 * @return the page content as List.
	 */
	public List<T2> getData() {
		return convert.convert2VOes(page.getContent());
	}

	/**
	 * Returns whether the Page has content at all.
	 * 
	 * @return whether the Page has content at all.
	 */
	public boolean hasData() {
		return page.hasContent();
	}

	public static Pageable getPageable(final int currentPage,
			final int pageCount, final Sort sort) {
		Pageable pageable = new Pageable() {

			/**
			 * Returns the sorting parameters.
			 */
			public Sort getSort() {
				return sort;
			}

			/**
			 * Returns the number of items to be returned.
			 */
			public int getPageSize() {
				return pageCount;
			}

			/**
			 * Returns the page to be returned.
			 */
			public int getPageNumber() {
				return currentPage;
			}

			/**
			 * Returns the offset to be taken according to the underlying page and page size.
			 */
			public int getOffset() {
				int offset = pageCount * (currentPage - 1);
				return offset < 0 ? 0 : offset;
			}

			public Pageable next() {
				// TODO Auto-generated method stub
				return null;
			}

			public Pageable previousOrFirst() {
				// TODO Auto-generated method stub
				return null;
			}

			public Pageable first() {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		return pageable;
	}

	@Override
	public String toString() {
		return "PageableVO [page=" + page + ", convert=" + convert + "]";
	}
}
