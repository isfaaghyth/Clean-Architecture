# Clean Arch
Android clean architecture with data binding. Based on MVP pattern.

Clean Arch adalah turunan dari pola arsitektur model-view-presenter (MVP). Paradigma ini di buat dalam memaksimalkan `maintenable code`. Sehingga, hal-hal yang esensial sudah di bundle dalam satu package.
Pola nya salam seperti MVP. Hanya saja saya coba refactor untuk menerapkan prinsip "`clean code`". Lifecycle nya pun saya coba buat sedikit berbeda (tidak secara keseluruhan), baik Activity maupun Fragment.

Kurang lebih paradigma nya seperti ini:

![arch](https://raw.githubusercontent.com/isfaaghyth/Clean-Architecture/master/lifecycle.png)

Dan menggunakan pustaka dari:
- [x] RxJava2
- [x] Retrofit2
- [x] Android DataBinding
- [x] Glide
- [x] Retro->Lambda

## contoh activity

```java
public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> implements MainView {

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected ActivityMainBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override protected void onCreated() {
        //do anything in here! or with android:onClick="doClick" and create doClick(view) method in this place.
        view.btnTest.onClickListener(v -> {
            Toast("Hi!");
        });
    }
    
}
```

## dengan utilitas kostuminisasi rxJava
- [SchedulerTransformer](https://github.com/isfaaghyth/Clean-Architecture/blob/master/app/src/main/java/isfaaghyth/app/cleanarch/util/rx/SchedulerTransformer.java)
- [MainScheduler](https://github.com/isfaaghyth/Clean-Architecture/blob/master/app/src/main/java/isfaaghyth/app/cleanarch/util/rx/MainScheduler.java)

## contoh presenter

```java
class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView view) {
        super.attachView(view);
    }

    void example() {
        subscribe(service.getHome()
                .compose(new MainScheduler<>())
                .subscribe(res -> {
                    if (res.isSuccessful()) {
                        view.onSuccess(res.body());
                    }
                }, err -> {
                    view.onError(err.getMessage());
                })
        );
    }

}
```

`Ruang kerja yang nyaman dapat mempengaruhi mobilitas pekerjaan, semakin nyaman dengan ruang lingkup, semakin fokus dalam bekerja.`

cheers!

@isfaaghyth, 2018.
