package com.bw.movie.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JiUpBean;
import com.bw.movie.bean.NowReBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.view.ChooseCinemaActivity;
import com.bw.movie.view.MoreActivity;
import com.bw.movie.view.XiangActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.List;
/**
 *@describe(描述)：MyAdapter
 *@data（日期）: 2019/11/14
 *@time（时间）: 19:18
 *@author（作者）: 王可欣
 **/
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  List<BannerBean.ResultBean> banners;
    private List<NowReBean.ResultBean> yList;
    private List<JiUpBean.ResultBean> jList;
    private List<RemenBean.ResultBean> hotList;
    private Context context;

    public MyAdapter(List<BannerBean.ResultBean> banners, List<NowReBean.ResultBean> yList, List<JiUpBean.ResultBean> jList, List<RemenBean.ResultBean> hotList, Context context) {
        this.banners = banners;
        this.yList = yList;
        this.jList = jList;
        this.hotList = hotList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.four_layout, parent, false);
            return new myFourHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.one_layout, parent, false);
            return new myOneHolder(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two_layout, parent, false);
            return new myTwoHolder(inflate);
        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three_layout, parent, false);
            return new myThreeHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                if (holder instanceof myFourHolder) {
                    if (banners != null) {
                        ((myFourHolder) holder).tab.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
                            @Override
                            public SimpleBannerInfo get(int index) {

                                return null;
                            }

                            @Override
                            public int size() {
                                return banners.size();
                            }
                        });
                        ((myFourHolder) holder).tab.loadImage(new XBanner.XBannerAdapter() {
                            @Override
                            public void loadBanner(XBanner banner, Object model, View view, int position) {
                                String imageUrl = banners.get(position).getImageUrl();

                                SimpleDraweeView simpleDraweeView = view.findViewById(R.id.my_image_view);
                                DraweeController controller = Fresco.newDraweeControllerBuilder()
                                        .setUri(imageUrl)
                                        .setAutoPlayAnimations(true)
                                        .build();
                                simpleDraweeView.setController(controller);
                                simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String jumpUrl = banners.get(position).getJumpUrl();
                                        String[] split = jumpUrl.split("=");
                                        Intent intent = new Intent(context, XiangActivity.class);
                                        int id= Integer.parseInt(split[1]);
                                        intent.putExtra("movieId",id);
                                        context.startActivity(intent);
                                    }
                                });
                                if (position==0){
                                    ((myFourHolder)holder).text.setText("" +banners.size()+ "/" + banners.size()+ "");
                                }else {
                                    ((myFourHolder)holder).text.setText("" + (position) + "/" + banners.size() + "");
                                }
                            }
                        });
                    }
                }
                break;
            case 1:
                if (holder instanceof myOneHolder) {
                    if (yList != null) {
                        ((myOneHolder) holder).more.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, MoreActivity.class);
                                context.startActivity(intent);
                            }
                        });
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                        ((myOneHolder) holder).onecy.setLayoutManager(linearLayoutManager);
                        MyYingAdapter myYingAdapter = new MyYingAdapter( yList,context);
                        ((myOneHolder) holder).onecy.setAdapter(myYingAdapter);
                    }
                }
                break;
            case 2:
                if (holder instanceof myTwoHolder) {
                    if (jList != null) {
                        ((myTwoHolder) holder).more2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, MoreActivity.class);
                                context.startActivity(intent);
                            }
                        });
                        ((myTwoHolder) holder).twocy.setLayoutManager(new LinearLayoutManager(context));
                        MyJYingAdapter myJYingAdapter = new MyJYingAdapter( jList,context);
                        ((myTwoHolder) holder).twocy.setAdapter(myJYingAdapter);
                        myJYingAdapter.setOnClickListener(new MyJYingAdapter.OnClickListener() {
                            @Override
                            public void click(int movieId) {
                                onClickListener.click(movieId);
                            }
                        });
                    }
                }
                break;
            case 3:
                if (holder instanceof myThreeHolder) {
                    if (hotList != null) {
                        ((myThreeHolder) holder).more3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, MoreActivity.class);
                                context.startActivity(intent);
                            }
                        });
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                        ((myThreeHolder) holder).threecy.setLayoutManager(linearLayoutManager);
                        MyHotAdapter myHotAdapter = new MyHotAdapter( hotList,context);
                        ((myThreeHolder) holder).threecy.setAdapter(myHotAdapter);
                        ((myThreeHolder) holder).nam.setText(hotList.get(0).getName());
                        ((myThreeHolder) holder).ping.setText(hotList.get(0).getScore()+"分");
                        ((myThreeHolder) holder).three_image.setImageURI(hotList.get(0).getHorizontalImage());
                        ((myThreeHolder) holder).three_image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(context, XiangActivity.class);
                                intent.putExtra("movieId",hotList.get(0).getMovieId());
                                context.startActivity(intent);
                            }
                        });
                        ((myThreeHolder) holder).btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, ChooseCinemaActivity.class);
                                int movieId = hotList.get(0).getMovieId();
                                intent.putExtra("movieId",movieId);
                                context.startActivity(intent);
                            }
                        });
                    }
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return 0;
    }

    public class myOneHolder extends RecyclerView.ViewHolder {
        private final RecyclerView onecy;
        private final TextView more;
        public myOneHolder(@NonNull View itemView) {
            super(itemView);
            onecy = itemView.findViewById(R.id.one_recy);
            more=itemView.findViewById(R.id.more);
        }
    }

    public class myTwoHolder extends RecyclerView.ViewHolder {
        private final RecyclerView twocy;
        private final TextView more2;
        public myTwoHolder(@NonNull View itemView) {
            super(itemView);
            twocy = itemView.findViewById(R.id.two_recy);
            more2=itemView.findViewById(R.id.more2);
        }
    }

    public class myThreeHolder extends RecyclerView.ViewHolder {

        private final RecyclerView threecy;
        private final SimpleDraweeView three_image;
        private final TextView ping,nam;
        private final Button btn;
        private final TextView more3;
        public myThreeHolder(@NonNull View itemView) {
            super(itemView);
            threecy = itemView.findViewById(R.id.three_recy);
            three_image = itemView.findViewById(R.id.three_image);
            ping=itemView.findViewById(R.id.ping_three);
            nam=itemView.findViewById(R.id.name_three);
            btn=itemView.findViewById(R.id.btn_three);
            more3=itemView.findViewById(R.id.more3);
        }
    }

    public class myFourHolder extends RecyclerView.ViewHolder {

        private final XBanner tab;
        private final TextView text;
        public myFourHolder(@NonNull View itemView) {
            super(itemView);
            tab = itemView.findViewById(R.id.four_tab);
            text=itemView.findViewById(R.id.page);
        }
    }


    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void click(int position);
    }
}
