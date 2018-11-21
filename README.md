# FrameCode
百搭常用框架

/**
 * 作者：Xiaobei Zhang on 2018/11/21 0021 10:45
 * <p>
 * 邮箱：languobeibei@163.com
 * Fragment的公共基类
 * CommonFrameFragment,ThirdPartyFragment,CustomFragment,OtherFragment等都要继承该类
 */
public abstract class BaseFragment extends Fragment{
    protected Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 强制子类实现重写,实现子类特有的UI
     * @return
     */
    protected abstract View initView() ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    /**
     * 当孩子需要初始化数据，或者联网请求绑定数据，或者展示数据的 等等可以重写该方法
     */
    protected  void initData(){

    }
}



