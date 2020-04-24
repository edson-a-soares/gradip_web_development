const
    gulp              = require("gulp"),
    cssNano           = require("gulp-cssnano"),
    gulpConcat        = require("gulp-concat"),
    gulpReplace       = require("gulp-replace"),
    requirejsOptimize = require("gulp-requirejs-optimize"),
    requireJS         = require("gulp-requirejs"),
    gulpClean         = require("gulp-rm"),
    uglify            = require("gulp-uglify"),
    gulpHtmlReplace   = require("gulp-html-replace"),
    replace           = require('gulp-replace'),
    target = {
        root:'../src/main/webapp/',
        js  :'../src/main/webapp/js/',
        css :'../src/main/webapp/css/'
    },
    styles = [
        'css/style.css',
        'css/material-icons.css',
        'css/roboto-varela-round.css',
        'node_modules/bootstrap/dist/css/bootstrap.css',
        'node_modules/font-awesome/css/font-awesome.css'
    ];

gulp.task('copy:index', function () {
    return gulp.src(['index.html'])
        .pipe(gulp.dest(target.root));
    });

gulp.task("index:replace:js", function () {
    return gulp.src([target.root + "/index.html"])
        .pipe(gulpReplace("node_modules/requirejs/require.js", "js/bundle.min.js"))
        .pipe(gulpReplace("data-main=\"app/startup\"", ""))
        .pipe(gulp.dest(target.root));
    });

gulp.task('index:replace:css', function () {
    return gulp.src(target.root + "/index.html")
        .pipe(gulpHtmlReplace({'css': 'css/bundle.min.css'}))
        .pipe(gulp.dest(target.root));
    });

gulp.task('bundle:js', function (done) {
        const result = requireJS({
            baseUrl: 'app',
            name: 'startup',
            mainConfigFile: 'app/startup.js',
            out: 'bundle.min.js',
            optimize: 'uglify2',
            findNestedDependencies: true,
            include: ['almond']
        })
        .pipe(gulp.dest(target.js));
        done();

        return result;
    });

gulp.task('bundle:css', function () {
    return gulp.src(styles.concat('css/*.css'))
        .pipe(gulpConcat('bundle.min.css'))
        .pipe(cssNano())
        .pipe(gulp.dest(target.css));
    });

gulp.task('clear:build', function () {
        return gulp.src(target.root + '/**', {read: false}).pipe(gulpClean());
    });

gulp.task("build", gulp.series("bundle:css", "bundle:js", "copy:index", "index:replace:css", "index:replace:js"));
